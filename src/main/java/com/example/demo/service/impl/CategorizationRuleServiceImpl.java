package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    @Autowired
    private CategorizationRuleRepository ruleRepository;

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        // Implementation depends on your Category model mapping
        // Usually: rule.setCategoryId(categoryId);
        return ruleRepository.save(rule);
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