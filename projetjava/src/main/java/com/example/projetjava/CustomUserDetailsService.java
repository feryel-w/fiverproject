package com.example.projetjava;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace with actual logic to retrieve user from the database
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                       .password("{bcrypt}$2a$10$wIyOgUwApOML7gB4w5SPCOJ7wtpNiApAokUizDdBl0m6Eze7k3GGi") // Example encrypted password
                       .roles("ADMIN")
                       .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
