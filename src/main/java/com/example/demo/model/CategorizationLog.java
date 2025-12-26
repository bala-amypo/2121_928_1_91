package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Category category;

    private String action;
    private LocalDateTime createdAt;

    public CategorizationLog() {}

    public CategorizationLog(Ticket ticket, Category category, String action) {
        this.ticket = ticket;
        this.category = category;
        this.action = action;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public Category getCategory() { return category; }
    public String getAction() { return action; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
