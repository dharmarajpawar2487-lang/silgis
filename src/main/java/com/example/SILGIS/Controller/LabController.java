package com.example.SILGIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LabController {


// ===== LAB LOGIN PAGE =====
@GetMapping("/lab")
public String openLab(
        @RequestParam("lab") String lab,
        Model model) {

    // Display lab name
    model.addAttribute("labName", lab);

    // Convert lab name to video file name
    String videoName = lab
            .toLowerCase()
            .replace(" ", "-");

    model.addAttribute("videoFile", videoName);

    return "lab_login";
}


// ===== VISITOR PANEL (QR SCAN TOUR) =====
@GetMapping("/lab-tour")
public String openLabTour(
        @RequestParam("lab") String lab,
        Model model) {

    model.addAttribute("labName", lab);

    String videoName = lab
            .toLowerCase()
            .replace(" ", "-");

    model.addAttribute("videoFile", videoName);

    return "visitor_panel";
}


}
