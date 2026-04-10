package com.example.SILGIS.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class VisitorService {

    private final String VALID_ID = "DhanDharm";
    private volatile boolean active = false;
    private volatile String currentVisitor = null;
    private volatile LocalDateTime activatedAt = null;

    public synchronized boolean validate(String visitorId){
        if(visitorId != null && visitorId.equals(VALID_ID)){
            active = true;
            currentVisitor = visitorId;
            activatedAt = LocalDateTime.now();
            return true;
        } else {
            active = false;
            currentVisitor = null;
            activatedAt = null;
            return false;
        }
    }

    public boolean isActive(){ return active; }
    public String getVisitor(){ return currentVisitor; }
    public LocalDateTime getActivatedAt(){ return activatedAt; }

    public void deactivate(){
        active = false;
        currentVisitor = null;
        activatedAt = null;
    }
}
