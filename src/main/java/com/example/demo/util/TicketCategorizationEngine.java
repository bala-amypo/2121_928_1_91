package com.example.demo.util;

import com.example.demo.model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(Ticket t, List<Category> categories, 
                           List<CategorizationRule> rules, 
                           List<UrgencyPolicy> policies, 
                           List<CategorizationLog> logs) {
        
        // 1. Safety Check: Handle null title/description to avoid NullPointerException
        String title = t.getTitle() != null ? t.getTitle() : "";
        String desc = t.getDescription() != null ? t.getDescription() : "";
        String text = (title + " " + desc).toLowerCase();

        // 2. CRITICAL FIX: Create a mutable copy of rules before sorting
        // List.of() in tests creates immutable lists; sorting them directly crashes the app.
        List<CategorizationRule> mutableRules = new ArrayList<>(rules);
        mutableRules.sort(Comparator.comparingInt(CategorizationRule::getPriority).reversed());

        boolean categoryFound = false;

        // 3. Apply Rules
        for (CategorizationRule rule : mutableRules) {
            String keyword = rule.getKeyword().toLowerCase();
            boolean match = false;
            
            if ("CONTAINS".equalsIgnoreCase(rule.getMatchType())) {
                if (text.contains(keyword)) match = true;
            } else if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
                // For exact match, we check if the keyword matches the content exactly
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

        // 4. Default to LOW if no category found
        if (!categoryFound) {
            t.setUrgencyLevel("LOW");
        }

        // 5. Apply Policies (Overrides)
        // Policies always override previous urgency decisions
        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                t.setUrgencyLevel(policy.getUrgencyOverride());
                // Policy application logic does not usually generate a standard categorization log 
                // in this spec, but the urgency is updated on the ticket object.
            }
        }
    }
}