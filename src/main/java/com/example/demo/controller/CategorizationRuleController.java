package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    @Autowired
    private CategorizationRuleService service;

    @PostMapping("/category/{categoryId}")
    public CategorizationRule createRule(@PathVariable Long categoryId, @RequestBody CategorizationRule rule) {
        return service.createRule(categoryId, rule);
    }

    @GetMapping("/{id}")
    public CategorizationRule getRule(@PathVariable Long id) {
        return service.getRule(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getByCategory(@PathVariable Long categoryId) {
        // This must match the method name in your Service Interface
        return service.getRulesByCategory(categoryId);
    }
} // <--- Check if this brace exists!