package com.yourapp.model;

import javax.persistence.*;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class CollectPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "collectPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionSchedule> schedules;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CollectionSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<CollectionSchedule> schedules) {
        this.schedules = schedules;
    }
}
