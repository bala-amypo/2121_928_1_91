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

    @PostMapping("/{categoryId}")
    public CategorizationRule create(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return service.create(categoryId, rule);
    }

    @GetMapping("/{id}")
    public CategorizationRule get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getByCategory(@PathVariable Long categoryId) {
        return service.getByCategory(categoryId);
    }
}
