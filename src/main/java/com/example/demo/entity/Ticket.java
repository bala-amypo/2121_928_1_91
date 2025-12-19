package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    private String location;
    private String createdBy;

    @ManyToOne
    private Category assignedCategory;

    private String urgencyLevel = "LOW";

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ticket")
    private List<CategorizationLog> logs;

    @ManyToOne
    private User createdByUser;

    public Ticket() {}

    public Ticket(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (urgencyLevel == null) urgencyLevel = "LOW";
    }

    // getters & setters
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setAssignedCategory(Category category) { this.assignedCategory = category; }
    public void setUrgencyLevel(String urgency) { this.urgencyLevel = urgency; }
}
