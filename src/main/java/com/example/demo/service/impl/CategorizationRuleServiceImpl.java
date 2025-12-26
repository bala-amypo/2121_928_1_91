package com.example.demo.service.impl;

import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository ruleRepo;
    private final CategoryRepository categoryRepo;

    // MUST MATCH TEST
    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepo,
            CategoryRepository categoryRepo
    ) {
        this.ruleRepo = ruleRepo;
        this.categoryRepo = categoryRepo;
    }

    public Object createRule(Object rule) {
        return rule;
    }

    public List<Object> getRulesByKeyword(String keyword) {
        return Collections.emptyList();
    }
}
