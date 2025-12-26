package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    @Override
    public Ticket categorizeTicket(Long ticketId) {
        return new Ticket(); // dummy
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return List.of(); // empty list
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return new CategorizationLog();
    }
}
