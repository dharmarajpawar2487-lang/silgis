package com.example.SILGIS.Controller;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.service.LogsService;
import com.example.SILGIS.service.VisitorService;
import com.example.SILGIS.Repository.VisitorLogRepo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class VisitorController {

    private final LogsService service;
    private final VisitorService visitorService;
    private final VisitorLogRepo visitorLogRepo;

    public VisitorController(LogsService service,
                             VisitorService visitorService,
                             VisitorLogRepo visitorLogRepo){
        this.service = service;
        this.visitorService = visitorService;
        this.visitorLogRepo = visitorLogRepo;
    }

    /* ================= HOME ================= */

    @GetMapping("/")
    public String index(){
        return "index";
    }

    /* ================= VISITOR FORM ================= */

    @GetMapping("/visitor-form")
    public String form(){
        return "visitor-form";
    }

    /* ================= MANUAL SAVE ================= */

    @PostMapping("/save")
    public String saveLog(VisitorLog log){
        service.save(log);
        return "redirect:/dashboard";
    }

    /* ================= MAIN VALIDATION FLOW ================= */

    @PostMapping("/validate")
    public String validateVisitor(@RequestParam String visitorId){

        boolean valid = visitorService.validate(visitorId);

        if(valid){

            VisitorLog log = new VisitorLog();
            log.setVisitorId(visitorId);
            log.setVisitorName("Dhanraj");
            log.setAction("Entered Lab");
            log.setLocation("IoT Lab");
            log.setEntryTime(LocalDateTime.now());

            visitorLogRepo.save(log);

            return "redirect:/dashboard";
        }

        return "redirect:/?error=true";
    }

    /* ================= API LOGIN ================= */

    @GetMapping("/visitor/login")
    @ResponseBody
    public String login(@RequestParam String visitorId){

        boolean valid = visitorService.validate(visitorId);

        return valid ? "SYSTEM ACTIVE" : "INVALID ID";
    }

}
