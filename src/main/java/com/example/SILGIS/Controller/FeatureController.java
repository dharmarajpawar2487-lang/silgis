package com.example.SILGIS.Controller;

import com.example.SILGIS.model.Feedback;
import com.example.SILGIS.model.Visitor;
import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.Repository.FeedbackRepo;
import com.example.SILGIS.Repository.VisitorLogRepo;
import com.example.SILGIS.Repository.VisitorRepository;
import com.example.SILGIS.service.VisitorService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/feature")
public class FeatureController {

    private final VisitorService visitorService;
    private final VisitorLogRepo logRepo;
    private final FeedbackRepo feedbackRepo;
    private final VisitorRepository visitorRepo;

    public FeatureController(VisitorService visitorService,
                             VisitorLogRepo logRepo,
                             FeedbackRepo feedbackRepo,
                             VisitorRepository visitorRepo){
        this.visitorService = visitorService;
        this.logRepo = logRepo;
        this.feedbackRepo = feedbackRepo;
        this.visitorRepo = visitorRepo;
    }

    /** ===========================
     *  LOCATION FEATURE
     *  =========================== */
    @GetMapping("/location")
    public String location(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/location";
    }

    /** ===========================
     *  AI VOICE GUIDE
     *  =========================== */
    @GetMapping("/ai_voice")
    public String aiVoice(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/ai_voice";
    }

    /** ===========================
     *  QR ACCESS
     *  =========================== */
    @GetMapping("/qr_access")
    public String qrAccess(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/qr_access";
    }

    /** ===========================
     *  LAB ENTRY PAGE (QR OPEN PAGE)
     *  =========================== */
    @GetMapping("/lab-entry")
    public String labEntry(@RequestParam String lab, Model m){
        m.addAttribute("labName", lab);
        return "features/lab_entry";
    }

    /** ===========================
     *  VERIFY VISITOR & SAVE LOG
     *  =========================== */
    @PostMapping("/lab-entry/verify")
    public String verifyVisitor(@RequestParam String visitorId,
                                @RequestParam String lab,
                                Model m){

        Visitor visitor = visitorRepo.findByVisitorId(visitorId).orElse(null);

        if(visitor == null){
            m.addAttribute("error","Invalid Visitor ID");
            return "features/lab_entry";
        }

        VisitorLog log = new VisitorLog();
        log.setVisitorId(visitor.getVisitorId());
        log.setVisitorName(visitor.getName());
        log.setAction("Entered Lab");
        log.setLocation(lab);
        log.setEntryTime(LocalDateTime.now());

        logRepo.save(log);

        return "redirect:/dashboard";
    }

    /** ===========================
     *  IOT CONTROL PANEL
     *  =========================== */
    @GetMapping("/iot_control")
    public String iotControl(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/iot_control";
    }

    /** ===========================
     *  LAB 3D
     *  =========================== */
    @GetMapping("/lab_3d")
    public String lab3d(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/lab_3d";
    }

    /** ===========================
     *  EMERGENCY
     *  =========================== */
    @GetMapping("/emergency")
    public String emergency(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/emergency";
    }

    /** ===========================
     *  FEEDBACK FORM
     *  =========================== */
    @GetMapping("/feedback")
    public String feedback(Model m){
        if(!visitorService.isActive()){
            m.addAttribute("error","System OFF");
            return "index";
        }
        return "features/feedback";
    }

    /** ===========================
     *  SAVE FEEDBACK
     *  =========================== */
    @PostMapping("/feedback/submit")
    public ResponseEntity<String> submit(
            @RequestParam String message,
            @RequestParam int rating
    ){
        if(!visitorService.isActive())
            return ResponseEntity.status(403).body("System OFF");

        Feedback fb = new Feedback(visitorService.getVisitor(), rating, message);
        feedbackRepo.save(fb);

        logRepo.save(new VisitorLog(visitorService.getVisitor(), "FEEDBACK_SUBMITTED"));

        return ResponseEntity.ok("Feedback Saved Successfully");
    }

    /** ===========================
     *  QR SUCCESS LOG
     *  =========================== */
    @PostMapping("/qr/success")
    public ResponseEntity<String> qrSuccess(){

        if(!visitorService.isActive())
            return ResponseEntity.status(403).body("System OFF");

        logRepo.save(new VisitorLog(visitorService.getVisitor(), "QR_SCANNED"));

        return ResponseEntity.ok("QR Logged Successfully");
    }
}