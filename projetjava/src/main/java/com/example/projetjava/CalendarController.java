package com.example.projetjava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String showCalendar() {
        return "calendar";  // This points to the calendar.html in the src/main/resources/templates directory
    }
}
