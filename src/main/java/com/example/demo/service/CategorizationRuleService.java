package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    // The test requires this specific constructor
    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository, CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        return categoryRepository.findById(categoryId).map(cat -> {
            rule.setCategory(cat);
            return ruleRepository.save(rule);
        }).orElse(null);
    }

    @Override
    public CategorizationRule getRule(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        return ruleRepository.findByCategoryId(categoryId);
    }
}