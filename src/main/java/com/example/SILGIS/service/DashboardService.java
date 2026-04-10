package com.example.SILGIS.service;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.Repository.VisitorLogRepo;
import com.example.SILGIS.Repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class DashboardService {
    private final VisitorRepository visitorRepo;
    private final VisitorLogRepo visitLogRepo;

    public DashboardService(VisitorRepository visitorRepo, VisitorLogRepo visitLogRepo) {
        this.visitorRepo = visitorRepo;
        this.visitLogRepo = visitLogRepo;
    }

    public long totalVisitors() {
        return visitorRepo.count();
    }

    public long todaysEntries() {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(LocalTime.MAX);
        return visitLogRepo.countByEntryTimeBetween(start, end);
    }

    public List<VisitorLog> recentLogs() {
        return visitLogRepo.findTop50ByOrderByEntryTimeDesc();
    }
}
