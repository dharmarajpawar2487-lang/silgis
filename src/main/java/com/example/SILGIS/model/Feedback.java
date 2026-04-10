package com.example.SILGIS.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visitorId;
    private int rating;
    @Column(length=2000)
    private String message;
    private LocalDateTime created;

    public Feedback(){}
    public Feedback(String visitorId, int rating, String message){
        this.visitorId = visitorId; this.rating = rating; this.message = message; this.created = LocalDateTime.now();
    }
    // getters/setters...
    public Long getId(){ return id; }
    public String getVisitorId(){ return visitorId; }
    public void setVisitorId(String v){ this.visitorId = v; }
    public int getRating(){ return rating; }
    public void setRating(int r){ this.rating = r; }
    public String getMessage(){ return message; }
    public void setMessage(String m){ this.message = m; }
    public LocalDateTime getCreated(){ return created; }
    public void setCreated(LocalDateTime c){ this.created = c; }
}
