package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // ✅ REQUIRED SETTER
    public void setCategory(Category category) {
        this.category = category;
    }

    // Optional but recommended
    public Category getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
