package com.example.SILGIS.Repository;

import com.example.SILGIS.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    long countByVisitDate(LocalDate visitDate);

    // 🔥 ADD THIS METHOD (IMPORTANT)
    Optional<Visitor> findByVisitorId(String visitorId);
}