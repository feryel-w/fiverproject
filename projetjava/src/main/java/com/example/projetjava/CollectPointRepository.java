package com.example.projetjava;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository for handling CollectionPoint entities
public interface CollectPointRepository extends JpaRepository<CollectPoint, Long> {
    // You can add custom queries here if needed
}
