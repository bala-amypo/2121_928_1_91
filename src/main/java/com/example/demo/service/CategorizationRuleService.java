package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule create(Long categoryId, CategorizationRule rule);
    CategorizationRule get(Long id);
    List<CategorizationRule> getByCategory(Long categoryId);
}
