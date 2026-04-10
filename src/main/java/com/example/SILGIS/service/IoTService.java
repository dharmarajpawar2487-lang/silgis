package com.example.SILGIS.service;

import com.example.SILGIS.model.DeviceLog;
import com.example.SILGIS.Repository.DeviceLogRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IoTService {

    private final DeviceLogRepo deviceLogRepo;

    public IoTService(DeviceLogRepo deviceLogRepo) {
        this.deviceLogRepo = deviceLogRepo;
    }

    // ✅ IoT ACTIVATE
    public void recordActivate(String visitorName) {
        DeviceLog log = new DeviceLog();
        log.setAction("IOT_ACTIVATE");
        log.setVisitorName(visitorName);
        log.setLogTime(LocalDateTime.now());
        deviceLogRepo.save(log);
    }

    // ✅ IoT DEACTIVATE
    public void recordDeactivate(String visitorName) {
        DeviceLog log = new DeviceLog();
        log.setAction("IOT_DEACTIVATE");
        log.setVisitorName(visitorName);
        log.setLogTime(LocalDateTime.now());
        deviceLogRepo.save(log);
    }

    // 🔥 NEW: IoT AUTO INTRO START
    public void recordIntroStart(String visitorName) {
        DeviceLog log = new DeviceLog();
        log.setAction("IOT_INTRO_STARTED");
        log.setVisitorName(visitorName);
        log.setLogTime(LocalDateTime.now());
        deviceLogRepo.save(log);
    }
}
