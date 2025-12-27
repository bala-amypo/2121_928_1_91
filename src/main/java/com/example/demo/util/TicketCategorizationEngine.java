package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

    // ✅ METHOD REQUIRED BY TESTS
    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(
                        rule.getCategory().getDefaultUrgency()
                );

                logs.add(new CategorizationLog(
                        ticket,
                        rule.getCategory(),
                        "RULE_MATCH"
                ));
                break;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(policy.getKeyword().toLowerCase())) {

                ticket.setUrgencyLevel(policy.getUrgencyOverride());

                logs.add(new CategorizationLog(
                        ticket,
                        ticket.getAssignedCategory(),
                        "URGENCY_OVERRIDE"
                ));
                break;
            }
        }
    }
}
