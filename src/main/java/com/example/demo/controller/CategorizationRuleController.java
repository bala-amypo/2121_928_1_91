package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService service;

    public CategorizationRuleController(CategorizationRuleService service) {
        this.service = service;
    }

    // POST /api/rules/{categoryId}
    @PostMapping("/{categoryId}")
    public CategorizationRule createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return service.createRule(categoryId, rule);
    }

    // GET /api/rules/{id}
    @GetMapping("/{id}")
    public CategorizationRule getRule(@PathVariable Long id) {
        return service.getRule(id);
    }

    // GET /api/rules/category/{categoryId}
    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getRulesByCategory(
            @PathVariable Long categoryId) {
        return service.getRulesByCategory(categoryId);
    }
}
