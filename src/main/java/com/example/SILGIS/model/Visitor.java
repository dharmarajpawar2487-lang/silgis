package com.example.SILGIS.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String visitorId;   // 🔥 VERY IMPORTANT

    @Column(nullable = false)
    private String name;

    private LocalDate visitDate;

    public Visitor() {
    }

    public Visitor(String visitorId, String name, LocalDate visitDate) {
        this.visitorId = visitorId;
        this.name = name;
        this.visitDate = visitDate;
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}