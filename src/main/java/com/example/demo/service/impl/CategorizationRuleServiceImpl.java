package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository repository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategorizationRule createRule(CategorizationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<CategorizationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public CategorizationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CategorizationRule> getRulesByKeyword(String keyword) {
        return repository.findByKeywordContainingIgnoreCase(keyword);
    }
}
