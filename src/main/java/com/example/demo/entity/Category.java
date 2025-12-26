package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "category")
    private List<UrgencyPolicy> urgencyPolicies;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<UrgencyPolicy> getUrgencyPolicies() { return urgencyPolicies; }
    public void setUrgencyPolicies(List<UrgencyPolicy> urgencyPolicies) { this.urgencyPolicies = urgencyPolicies; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}