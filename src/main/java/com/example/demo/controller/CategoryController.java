package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return service.get(id);
    }
}
