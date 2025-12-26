package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Category category;

    private String urgency;

    public CategorizationLog() {}

    // ✅ REQUIRED BY TicketCategorizationEngine
    public CategorizationLog(Ticket ticket, Category category, String urgency) {
        this.ticket = ticket;
        this.category = category;
        this.urgency = urgency;
    }

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Category getCategory() {
        return category;
    }

    public String getUrgency() {
        return urgency;
    }
}
