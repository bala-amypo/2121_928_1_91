package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Categorization Rules")
public class CategorizationRuleController {

    private final CategorizationRuleService service;

    public CategorizationRuleController(CategorizationRuleService service) {
        this.service = service;
    }

    // POST /api/rules/{categoryId}
    @PostMapping("/{categoryId}")
    public ResponseEntity<CategorizationRule> createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {

        CategorizationRule savedRule = service.createRule(categoryId, rule);
        return new ResponseEntity<>(savedRule, HttpStatus.CREATED);
    }

    // GET /api/rules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRule(id));
    }

    // GET /api/rules/category/{categoryId}
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategorizationRule>> getRulesByCategory(
            @PathVariable Long categoryId) {

        return ResponseEntity.ok(service.getByCategory(categoryId));
    }
}
