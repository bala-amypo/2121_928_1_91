package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService service;

    public CategorizationRuleController(CategorizationRuleService service) {
        this.service = service;
    }

    // Create a new rule
    @PostMapping
    public ResponseEntity<CategorizationRule> createRule(@RequestBody CategorizationRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    // Get all rules
    @GetMapping
    public ResponseEntity<List<CategorizationRule>> getAllRules() {
        return ResponseEntity.ok(service.getAllRules());
    }

    // Get rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> getRuleById(@PathVariable Long id) {
        CategorizationRule rule = service.getRuleById(id);
        if (rule != null) {
            return ResponseEntity.ok(rule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete rule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
        return ResponseEntity.noContent().build();
    }

    // Search rules by keyword
    @GetMapping("/search")
    public ResponseEntity<List<CategorizationRule>> searchRules(@RequestParam String keyword) {
        return ResponseEntity.ok(service.getRulesByKeyword(keyword));
    }
}
