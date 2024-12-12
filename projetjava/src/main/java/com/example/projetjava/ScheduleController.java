package com.example.projetjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Endpoint to add a new schedule
    @PostMapping("/addSchedule")
    public String addSchedule(@RequestBody ScheduleRequest request) {
        scheduleService.addSchedule(request);
        return "Schedule added successfully!";
    }
}
