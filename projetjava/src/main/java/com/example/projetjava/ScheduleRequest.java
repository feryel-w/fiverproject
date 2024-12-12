package com.example.projetjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleRequest {
    public Long getPointId() {
		return pointId;
	}

	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	private Long pointId;
    private String start;
    private String end;

    // Getters and Setters

    // Convert the start and end strings to LocalDateTime objects
    public LocalDateTime getStartAsLocalDateTime() {
        return LocalDateTime.parse(this.start, DateTimeFormatter.ISO_DATE_TIME);  // Adjust the format if needed
    }

    public LocalDateTime getEndAsLocalDateTime() {
        return LocalDateTime.parse(this.end, DateTimeFormatter.ISO_DATE_TIME);  // Adjust the format if needed
    }
}
