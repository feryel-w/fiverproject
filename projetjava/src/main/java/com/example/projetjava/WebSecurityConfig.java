package com.example.projetjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());

        // Make sure to allow access to the collectpoints API endpoint and other necessary resources
        http.authorizeHttpRequests(auth -> 
            auth.requestMatchers("/users").authenticated()
                .requestMatchers("/api/collectpoints").permitAll()  // Allow access to collectpoints endpoint
                .requestMatchers("/admin/collect-points/save").permitAll()  // Allow save endpoint
                .anyRequest().permitAll()  // Allow access to all other requests
        )
        .formLogin(login -> login.usernameParameter("email")
                                 .defaultSuccessUrl("/users")
                                 .permitAll())
        .logout(logout -> logout.logoutSuccessUrl("/").permitAll())
        .csrf().disable();  // Disable CSRF protection for simplicity (you can customize as needed)

        return http.build();
    }
}
