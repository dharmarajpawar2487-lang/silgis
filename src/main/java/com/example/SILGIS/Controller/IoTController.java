package com.example.SILGIS.Controller;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.Repository.VisitorLogRepo;
import com.example.SILGIS.service.VisitorService;
import com.example.SILGIS.service.IoTService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IoTController {

    private final VisitorService visitorService;
    private final VisitorLogRepo visitorLogRepo;
    private final IoTService iotService;

    // ✅ FIXED CONSTRUCTOR (only required beans)
    public IoTController(VisitorService visitorService,
                         VisitorLogRepo visitorLogRepo,
                         IoTService iotService) {

        this.visitorService = visitorService;
        this.visitorLogRepo = visitorLogRepo;
        this.iotService = iotService;
    }

    // ===============================
    // ✅ PAGE LOADER
    // ===============================
    @GetMapping("/iot")
    public String iotPage() {
        return "features/iot_control";
    }

    // ===============================
    // 🔥 API : IOT INTRO (FEATURE CLICK)
    // ===============================
    @PostMapping("/api/iot/intro/start")
    @ResponseBody
    public ResponseEntity<String> startIntro() {

        if (!visitorService.isActive()) {
            return ResponseEntity.status(403).body("System OFF");
        }

        String visitorName = visitorService.getVisitor();

        // ✅ DeviceLog entry
        iotService.recordIntroStart(visitorName);

        // ✅ VisitorLog entry
        visitorLogRepo.save(
                new VisitorLog(visitorName, "IOT_INTRO_STARTED")
        );

        return ResponseEntity.ok("IoT Intro Started & Logged");
    }

    // ===============================
    // ✅ API : ACTIVATE IOT
    // ===============================
    @PostMapping("/api/iot/activate")
    @ResponseBody
    public ResponseEntity<String> activate() {

        if (!visitorService.isActive()) {
            return ResponseEntity.status(403).body("System OFF");
        }

        String visitorName = visitorService.getVisitor();

        iotService.recordActivate(visitorName);
        visitorLogRepo.save(
                new VisitorLog(visitorName, "IOT_ACTIVATE")
        );

        return ResponseEntity.ok("IOT Activated");
    }

    // ===============================
    // ✅ API : DEACTIVATE IOT
    // ===============================
    @PostMapping("/api/iot/deactivate")
    @ResponseBody
    public ResponseEntity<String> deactivate() {

        if (!visitorService.isActive()) {
            return ResponseEntity.status(403).body("System OFF");
        }

        String visitorName = visitorService.getVisitor();

        iotService.recordDeactivate(visitorName);
        visitorLogRepo.save(
                new VisitorLog(visitorName, "IOT_DEACTIVATE")
        );

        return ResponseEntity.ok("IOT Deactivated");
    }

    // ===============================
    // ✅ API : SYSTEM STATUS
    // ===============================
    @GetMapping("/api/system/status")
    @ResponseBody
    public String status() {
        return visitorService.isActive() ? "ACTIVE" : "OFF";
    }
}
