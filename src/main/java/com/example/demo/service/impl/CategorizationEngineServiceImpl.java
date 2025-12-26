package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.util.TicketCategorizationEngine;

import java.util.List;

public class CategorizationEngineServiceImpl {

    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketCategorizationEngine engine
    ) {
        this.engine = engine;
    }

    public void run(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {
        engine.categorize(ticket, categories, rules, policies, logs);
    }
}
