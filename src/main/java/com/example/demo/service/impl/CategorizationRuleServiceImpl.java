package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl
        implements CategorizationRuleService {

    private final CategorizationRuleRepository repository;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategorizationRule createRule(CategorizationRule rule) {
        return repository.save(rule);
    }

    @Override
    public CategorizationRule getRule(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<CategorizationRule> getRulesByKeyword(String keyword) {
        return repository.findByKeywordContainingIgnoreCase(keyword);
    }
}
