package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Category category;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String matchType;

    private Integer priority = 1;

    private LocalDateTime createdAt;

    public CategorizationRule() {}

    @PrePersist
    void onCreate() {
        if (priority == null) priority = 1;
        this.createdAt = LocalDateTime.now();
    }

    // getters
    public String getKeyword() { return keyword; }
    public String getMatchType() { return matchType; }
    public Category getCategory() { return category; }
    public Integer getPriority() { return priority; }
}
