package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String urgencyOverride;

    private LocalDateTime createdAt;

    public UrgencyPolicy() {}

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters
    public String getKeyword() { return keyword; }
    public String getUrgencyOverride() { return urgencyOverride; }
}
