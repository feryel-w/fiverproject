package com.example.projetjava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<CollectionSchedule, Long> {
    // You can define custom query methods if needed
}
