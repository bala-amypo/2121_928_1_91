package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category create(Category category) {
        return repo.save(category);
    }

    public Category get(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}
