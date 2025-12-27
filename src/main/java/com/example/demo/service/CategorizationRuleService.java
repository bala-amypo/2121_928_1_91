// package com.example.demo.service;

// import com.example.demo.model.CategorizationRule;
// import java.util.List;

// public interface CategorizationRuleService {

//     // Create a new rule
//     CategorizationRule createRule(CategorizationRule rule);

//     // Get all rules
//     List<CategorizationRule> getAllRules();

//     // Get rule by ID
//     CategorizationRule getRuleById(Long id);

//     // Delete rule by ID
//     void deleteRule(Long id);

//     // Optional: method for searching by keyword
//     List<CategorizationRule> getRulesByKeyword(String keyword);
// }


package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule createRule(Long categoryId, CategorizationRule rule);
    List<CategorizationRule> getAllRules();
}