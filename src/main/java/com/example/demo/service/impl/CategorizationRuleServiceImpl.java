package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository categorizationRuleRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository categorizationRuleRepository) {
        this.categorizationRuleRepository = categorizationRuleRepository;
    }

    @Override
    public CategorizationRule createRule(CategorizationRule rule) {
        return categorizationRuleRepository.save(rule);
    }

    @Override
    public CategorizationRule getRule(Long id) {
        return categorizationRuleRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategorizationRule> getAllRules() {
        return categorizationRuleRepository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        categorizationRuleRepository.deleteById(id);
    }

    @Override
    public List<CategorizationRule> findByKeyword(String keyword) {
        return categorizationRuleRepository.findByKeywordContainingIgnoreCase(keyword);
    }
}
