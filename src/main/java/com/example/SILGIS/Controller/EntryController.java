package com.example.SILGIS.Controller;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.Repository.VisitorLogRepo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/api/entry")
public class EntryController {

private final VisitorLogRepo visitLogRepo;

public EntryController(VisitorLogRepo visitLogRepo) {
    this.visitLogRepo = visitLogRepo;
}

@PostMapping("/activate")
public String activateVisitor(
        @RequestParam String visitorName,
        @RequestParam String labName
) {

    System.out.println("---- ENTRY REQUEST RECEIVED ----");
    System.out.println("Visitor Name: " + visitorName);
    System.out.println("Lab Name: " + labName);

    // 🔹 Generate Visitor ID automatically
    String visitorId = UUID.randomUUID().toString();

    // 🔹 Create Log
    VisitorLog log = new VisitorLog();
    log.setVisitorId(visitorId);
    log.setVisitorName(visitorName);
    log.setAction("Entered Lab");
    log.setLocation(labName);
    log.setEntryTime(LocalDateTime.now());

    // 🔹 Save Log
    visitLogRepo.save(log);

    System.out.println("Visitor Saved Successfully");

    // 🔹 Redirect Visitor Panel
    return "redirect:/visitor-panel?lab=" + labName;
}

}
