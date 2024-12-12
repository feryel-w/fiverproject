package com.example.projetjava;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Add a new schedule
    public ScheduleEvent addSchedule(ScheduleRequest scheduleRequest) {
        // Convert the strings to LocalDateTime
        LocalDateTime start = scheduleRequest.getStartAsLocalDateTime();
        LocalDateTime end = scheduleRequest.getEndAsLocalDateTime();

        CollectionSchedule schedule = new CollectionSchedule();
        schedule.setPointId(scheduleRequest.getPointId());
        schedule.setHeureDebut(start);  // Set the start time as LocalDateTime
        schedule.setHeureFin(end);      // Set the end time as LocalDateTime

        scheduleRepository.save(schedule);

        return new ScheduleEvent(
            schedule.getId(),
            "Collection Point: " + schedule.getPointId(),
            schedule.getHeureDebut().toString(),
            schedule.getHeureFin().toString()
        );
    }
}
