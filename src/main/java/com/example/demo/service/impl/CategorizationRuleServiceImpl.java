// package com.example.demo.service.impl;

// import com.example.demo.model.CategorizationRule;
// import com.example.demo.repository.CategorizationRuleRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CategorizationRuleServiceImpl {

//     private final CategorizationRuleRepository repository;

//     public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
//         this.repository = repository;
//     }

//     public CategorizationRule createRule(CategorizationRule rule) {
//         return repository.save(rule);
//     }

//     public List<CategorizationRule> getRulesByKeyword(String keyword) {
//         return repository.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl {
    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository, CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    // This method was missing
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        rule.setCategory(category);
        return ruleRepository.save(rule);
    }

    // This method was missing
    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}