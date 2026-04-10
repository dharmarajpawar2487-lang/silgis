package com.example.SILGIS.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitor_logs")
public class VisitorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String visitorId;

    @Column(nullable = false)
    private String visitorName;

    @Column(nullable = false)
    private String action;

    private String location;

    @Column(nullable = false)
    private LocalDateTime entryTime;

    /* ================= CONSTRUCTORS ================= */

    public VisitorLog() {
        // Required by JPA
    }

    // Professional Constructor
    public VisitorLog(String visitorId, String visitorName,
                      String action, String location) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.action = action;
        this.location = location;
        this.entryTime = LocalDateTime.now();
    }

    /* ================= AUTO TIME BEFORE INSERT ================= */

    @PrePersist
    protected void onCreate() {
        if (this.entryTime == null) {
            this.entryTime = LocalDateTime.now();
        }
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}