package com.example.projetjava;

public class CollectionScheduleDTO {

    private Long id;
    private Long pointId;
    private String heureDebut;
    private String heureFin;

    // Constructor
    public CollectionScheduleDTO(Long id, Long pointId, String heureDebut, String heureFin) {
        this.id = id;
        this.pointId = pointId;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
}
