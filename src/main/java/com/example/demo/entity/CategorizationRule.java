package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchType;
    private int priority;
    private String keyword;
    private LocalDateTime createdAt;

    @ManyToOne
    private Category category;

    @PrePersist
    protected void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.priority == 0) this.priority = 1;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}