package com.example.projetjava;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class CollectionSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date heureDebut;
    private Date heureFin;

    @ManyToOne
    @JoinColumn(name = "collect_point_id") // Foreign key to CollectPoint
    private CollectPoint collectPoint;

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public CollectPoint getCollectPoint() {
        return collectPoint;
    }

    public void setCollectPoint(CollectPoint collectPoint) {
        this.collectPoint = collectPoint;
    }
}
