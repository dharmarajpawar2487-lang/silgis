package com.example.SILGIS.Controller;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.service.LogsService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import java.util.List;

@Controller
public class LogsController {

    private final LogsService service;

    public LogsController(LogsService service){
        this.service = service;
    }

    // 1️⃣ Normal Page View (HTML Page)
    @GetMapping("/logs/all")
    public String showLogs(Model model){
        model.addAttribute("list", service.findAll());
        return "logs";
    }

    // 2️⃣ Dashboard API (JSON Response for Live Table)
    @GetMapping("/api/logs")
    @ResponseBody
    public List<VisitorLog> getAllLogs(){
        return service.findAllSorted();
    }
}