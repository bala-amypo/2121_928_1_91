package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository; // Assuming you have this
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    @Autowired
    private CategorizationRuleRepository ruleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        // 1. Fetch the category to ensure it exists
        return categoryRepository.findById(categoryId).map(category -> {
            // 2. Link the rule to the category (assuming a setCategory method exists)
            rule.setCategory(category); 
            // 3. Save and return
            return ruleRepository.save(rule);
        }).orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
    }

    @Override
    public CategorizationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found with id " + id));
    }

    @Override
    public List<CategorizationRule> getByCategory(Long categoryId) {
        // Ensure your Repository has a method findByCategoryId(Long id)
        return ruleRepository.findByCategoryId(categoryId);
    }
}