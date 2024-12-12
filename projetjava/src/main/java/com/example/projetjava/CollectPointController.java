package com.example.projetjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collectpoints")
public class CollectPointController {

    @Autowired
    private CollectPointRepository collectPointRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all collection points with their schedules
    @GetMapping
    public List<CollectPoint> getAllCollectPoints() {
        return collectPointRepository.findAll();
    }

    // Get schedules for a specific collect point
    @GetMapping("/{collectPointId}/schedules")
    public List<CollectionSchedule> getSchedulesForCollectPoint(@PathVariable Long collectPointId) {
        Optional<CollectPoint> collectPoint = collectPointRepository.findById(collectPointId);
        if (collectPoint.isPresent()) {
            return collectPoint.get().getSchedules();
        } else {
            throw new RuntimeException("Collect point not found");
        }
    }


    // Update or add a schedule for a specific collect point
    @PutMapping("/{collectPointId}/schedules")
    public CollectionSchedule updateSchedule(@PathVariable Long collectPointId, @RequestBody CollectionSchedule schedule) {
        Optional<CollectPoint> collectPoint = collectPointRepository.findById(collectPointId);
        if (collectPoint.isPresent()) {
            schedule.setCollectPoint(collectPoint.get());
            return scheduleRepository.save(schedule);  // Use scheduleRepository to save
        } else {
            throw new RuntimeException("Collect point not found");
        }
    }
}
