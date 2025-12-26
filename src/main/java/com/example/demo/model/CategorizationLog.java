package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Ticket ticket;

    @ManyToOne(optional = false)
    private CategorizationRule appliedRule;

    @Column(nullable = false)
    private String matchedKeyword;

    @Column(nullable = false)
    private String assignedCategory;

    @Column(nullable = false)
    private String assignedUrgency;

    private LocalDateTime loggedAt;

    public CategorizationLog() {}

    @PrePersist
    void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public CategorizationLog(Ticket ticket, CategorizationRule rule,
                             String matchedKeyword, String category, String urgency) {
        this.ticket = ticket;
        this.appliedRule = rule;
        this.matchedKeyword = matchedKeyword;
        this.assignedCategory = category;
        this.assignedUrgency = urgency;
    }
}
