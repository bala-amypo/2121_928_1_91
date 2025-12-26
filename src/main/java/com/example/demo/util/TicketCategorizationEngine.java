package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

    public void applyRules(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies
    ) {

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(
                        rule.getCategory().getDefaultUrgency()
                );
                break;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(policy.getKeyword().toLowerCase())) {

                ticket.setUrgencyLevel(policy.getUrgencyOverride());
                break;
            }
        }
    }
}
