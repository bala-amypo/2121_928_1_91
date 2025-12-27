// package com.example.demo.util;

// import com.example.demo.model.*;

// import java.util.List;

// public class TicketCategorizationEngine {

//     // ✅ METHOD REQUIRED BY TESTS
//     public void categorize(
//             Ticket ticket,
//             List<Category> categories,
//             List<CategorizationRule> rules,
//             List<UrgencyPolicy> policies,
//             List<CategorizationLog> logs
//     ) {

//         for (CategorizationRule rule : rules) {
//             if (ticket.getDescription() != null &&
//                 ticket.getDescription().toLowerCase()
//                         .contains(rule.getKeyword().toLowerCase())) {

//                 ticket.setAssignedCategory(rule.getCategory());
//                 ticket.setUrgencyLevel(
//                         rule.getCategory().getDefaultUrgency()
//                 );

//                 logs.add(new CategorizationLog(
//                         ticket,
//                         rule.getCategory(),
//                         "RULE_MATCH"
//                 ));
//                 break;
//             }
//         }

//         for (UrgencyPolicy policy : policies) {
//             if (ticket.getDescription() != null &&
//                 ticket.getDescription().toLowerCase()
//                         .contains(policy.getKeyword().toLowerCase())) {

//                 ticket.setUrgencyLevel(policy.getUrgencyOverride());

//                 logs.add(new CategorizationLog(
//                         ticket,
//                         ticket.getAssignedCategory(),
//                         "URGENCY_OVERRIDE"
//                 ));
//                 break;
//             }
//         }
//     }
// }

package com.example.demo.util;

import com.example.demo.model.*;
import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(Ticket t, List<Category> categories, 
                           List<CategorizationRule> rules, 
                           List<UrgencyPolicy> policies, 
                           List<CategorizationLog> logs) {
        
        // 1. Sort rules by priority (high to low)
        rules.sort(Comparator.comparingInt(CategorizationRule::getPriority).reversed());

        boolean categoryFound = false;
        String text = (t.getTitle() + " " + t.getDescription()).toLowerCase();

        // 2. Apply Rules
        for (CategorizationRule rule : rules) {
            String keyword = rule.getKeyword().toLowerCase();
            boolean match = false;
            
            if ("CONTAINS".equalsIgnoreCase(rule.getMatchType())) {
                if (text.contains(keyword)) match = true;
            } else if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
                if (text.equals(keyword)) match = true;
            }

            if (match) {
                t.setAssignedCategory(rule.getCategory());
                t.setUrgencyLevel(rule.getCategory().getDefaultUrgency());
                
                // Create Log
                CategorizationLog log = new CategorizationLog();
                log.setTicket(t);
                log.setAppliedRule(rule);
                log.setMatchedKeyword(rule.getKeyword());
                log.setAssignedCategory(rule.getCategory().getCategoryName());
                log.setAssignedUrgency(rule.getCategory().getDefaultUrgency());
                logs.add(log);
                
                categoryFound = true;
                break; // Stop after highest priority match
            }
        }

        if (!categoryFound) {
            t.setUrgencyLevel("LOW");
        }

        // 3. Apply Policies (Overrides)
        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                t.setUrgencyLevel(policy.getUrgencyOverride());
                // Policy logs can be added here if required, but logs usually track rule matching
            }
        }
    }
}
