package com.example.SILGIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorPanelController {

    // ================= VISITOR PANEL =================

    @GetMapping("/visitor-panel")
    public String openLabTour(
            @RequestParam(name = "lab", required = false) String lab,
            Model model) {

        // Default lab if parameter missing
        if (lab == null || lab.isEmpty()) {
            lab = "Programming Lab";
        }

        // Send lab name to HTML
        model.addAttribute("labName", lab);

        // Convert lab name to video file name
        String videoName = lab
                .toLowerCase()
                .replace(" ", "-");

        // Fix: add "-lab" only for labs (not HOD cabin)
        if (!videoName.contains("lab") && !videoName.equals("hod-cabin")) {
            videoName = videoName + "-lab";
        }

        // Send video file name to HTML
        model.addAttribute("videoFile", videoName);

        // Open visitor panel page
        return "visitor_panel";
    }


    // ================= HOD CABIN 3D TOUR =================

    @GetMapping("/hod-cabin")
    public String openHodCabin() {

        return "hod_cabin";

    }

}