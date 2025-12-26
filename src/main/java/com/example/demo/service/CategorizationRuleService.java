package com.example.demo.service;

import com.example.demo.model.CategorizationRule;

import java.util.List;

public interface CategorizationRuleService {

    CategorizationRule create(CategorizationRule rule);

    CategorizationRule getById(Long id);

    List<CategorizationRule> getByCategory(Long categoryId);

    // 🔴 THIS METHOD WAS MISSING IN IMPL
    List<CategorizationRule> getRulesByKeyword(String keyword);
}
