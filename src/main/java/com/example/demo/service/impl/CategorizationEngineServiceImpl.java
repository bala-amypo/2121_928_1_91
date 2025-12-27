// package com.example.demo.service.impl;

// import com.example.demo.model.CategorizationLog;
// import com.example.demo.repository.*;
// import com.example.demo.util.TicketCategorizationEngine;
// import org.springframework.stereotype.Service;

// import java.util.Collections;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class CategorizationEngineServiceImpl {

//     private final TicketRepository ticketRepo;
//     private final CategoryRepository categoryRepo;
//     private final CategorizationRuleRepository ruleRepo;
//     private final UrgencyPolicyRepository urgencyRepo;
//     private final CategorizationLogRepository logRepo;
//     private final TicketCategorizationEngine engine;

//     // EXACT MATCH TO TEST
//     public CategorizationEngineServiceImpl(
//             TicketRepository ticketRepo,
//             CategoryRepository categoryRepo,
//             CategorizationRuleRepository ruleRepo,
//             UrgencyPolicyRepository urgencyRepo,
//             CategorizationLogRepository logRepo,
//             TicketCategorizationEngine engine
//     ) {
//         this.ticketRepo = ticketRepo;
//         this.categoryRepo = categoryRepo;
//         this.ruleRepo = ruleRepo;
//         this.urgencyRepo = urgencyRepo;
//         this.logRepo = logRepo;
//         this.engine = engine;
//     }

//     public void categorizeTicket(long ticketId) {
//         // stub
//     }

//     public List<CategorizationLog> getLogsForTicket(long ticketId) {
//         return Collections.emptyList();
//     }

//     public Optional<CategorizationLog> getLog(long logId) {
//         return Optional.empty();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl {
    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(TicketRepository ticketRepository,
                                           CategoryRepository categoryRepository,
                                           CategorizationRuleRepository ruleRepository,
                                           UrgencyPolicyRepository policyRepository,
                                           CategorizationLogRepository logRepository,
                                           TicketCategorizationEngine engine) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    public Ticket categorizeTicket(Long ticketId) {
        Ticket t = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<Category> categories = categoryRepository.findAll();
        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();
        List<CategorizationLog> logs = new ArrayList<>();

        engine.categorize(t, categories, rules, policies, logs);

        logRepository.saveAll(logs);
        return ticketRepository.save(t);
    }

    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    public CategorizationLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}