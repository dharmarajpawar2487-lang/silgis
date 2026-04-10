package com.example.SILGIS.service;

import com.example.SILGIS.model.VisitorLog;
import com.example.SILGIS.Repository.VisitorLogRepo;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class LogsService {

    private final VisitorLogRepo repo;

    public LogsService(VisitorLogRepo repo){
        this.repo = repo;
    }

    // 1️⃣ Normal fetch (unsorted)
    public List<VisitorLog> findAll(){
        return repo.findAll();
    }

    // 2️⃣ Dashboard use साठी latest first (EntryTime DESC)
    public List<VisitorLog> findAllSorted(){
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "entryTime")
        );
    }

    // 3️⃣ Save log
    public VisitorLog save(VisitorLog log){
        return repo.save(log);
    }
}