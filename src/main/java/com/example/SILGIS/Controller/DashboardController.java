package com.example.SILGIS.Controller;

import com.example.SILGIS.Repository.VisitorLogRepo;
import com.example.SILGIS.model.VisitorLog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DashboardController {

    private final VisitorLogRepo visitorLogRepo;

    public DashboardController(VisitorLogRepo visitorLogRepo) {
        this.visitorLogRepo = visitorLogRepo;
    }

    /* ===========================
       MAIN DASHBOARD PAGE
       =========================== */
    @GetMapping("/dashboard")
    public String dashboard(Model model){

        // 🔹 Latest 10 Logs
        List<VisitorLog> logs =
                visitorLogRepo.findTop10ByOrderByEntryTimeDesc();
        model.addAttribute("logs", logs);

        // 🔹 Total Entries (All Time)
        long totalVisitors = visitorLogRepo.count();
        model.addAttribute("totalVisitors", totalVisitors);

        // 🔹 Today's Entries
        LocalDateTime start =
                LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        long todayEntries =
                visitorLogRepo.countByEntryTimeBetween(start, end);
        model.addAttribute("todayEntries", todayEntries);

        // 🔹 Active Inside Lab (Entered but not Exited)
        long activeInside =
                visitorLogRepo.countByAction("Entered Lab");
        model.addAttribute("activeInside", activeInside);

        return "dashboard";
    }

    /* ===========================
       LIVE API (For Auto Update)
       =========================== */
    @GetMapping("/api/logs/latest")
    @ResponseBody
    public List<VisitorLog> latestLogs(){
        return visitorLogRepo.findTop10ByOrderByEntryTimeDesc();
    }
}