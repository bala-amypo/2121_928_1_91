package com.example.demo.service;

import com.example.demo.model.Category;

public interface CategoryService {
    Category create(Category category);
    Category get(Long id);
}
