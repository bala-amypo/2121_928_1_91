// package com.example.demo.controller;

// import com.example.demo.model.Category;
// import com.example.demo.service.CategoryService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/categories")
// public class CategoryController {

//     private final CategoryService service;

//     public CategoryController(CategoryService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public Category create(@RequestBody Category c) {
//         return service.createCategory(c);
//     }

//     @GetMapping("/{id}")
//     public Category get(@PathVariable Long id) {
//         return service.getCategory(id);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
