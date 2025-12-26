package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;

import java.util.List;
import java.util.stream.Collectors;

public class CategorizationRuleServiceImpl
        implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepository,
            CategoryRepository categoryRepository
    ) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorizationRule create(CategorizationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public CategorizationRule getById(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategorizationRule> getByCategory(Long categoryId) {
        return ruleRepository.findAll();
    }

    @Override
    public List<CategorizationRule> getRulesByKeyword(String keyword) {
        return ruleRepository.findAll()
                .stream()
                .filter(r ->
                        r.getKeyword() != null &&
                        r.getKeyword().equalsIgnoreCase(keyword)
                )
                .collect(Collectors.toList());
    }
}
