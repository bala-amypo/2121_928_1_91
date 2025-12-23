package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category assignedCategory;

    private String urgencyLevel;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        if (urgencyLevel == null) urgencyLevel = "LOW";
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setAssignedCategory(Category category) { this.assignedCategory = category; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
}
