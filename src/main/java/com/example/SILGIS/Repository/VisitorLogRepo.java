package com.example.SILGIS.Repository;

import com.example.SILGIS.model.VisitorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitorLogRepo extends JpaRepository<VisitorLog, Long> {

    /* ================= DASHBOARD COUNT METHODS ================= */

    // Count today's entries
    long countByEntryTimeBetween(LocalDateTime from, LocalDateTime to);

    // Count by action (Entered / Exited)
    long countByAction(String action);

    // Count by lab location
    long countByLocation(String location);

    /* ================= FETCH METHODS ================= */

    // Get logs between time range
    List<VisitorLog> findByEntryTimeBetween(LocalDateTime from,
                                            LocalDateTime to);

    // Get logs by visitor
    List<VisitorLog> findByVisitorId(String visitorId);

    // Get logs by lab location
    List<VisitorLog> findByLocation(String location);

    // Latest 10 logs for dashboard
    List<VisitorLog> findTop10ByOrderByEntryTimeDesc();

    /* ================= TOGGLE SUPPORT ================= */

    // Get last log of visitor (for Enter/Exit toggle)
    VisitorLog findTopByVisitorIdOrderByEntryTimeDesc(String visitorId);
}