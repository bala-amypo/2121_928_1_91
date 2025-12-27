// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class CategorizationLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Ticket ticket;

//     @ManyToOne
//     private Category category;

//     private String urgency;

//     public CategorizationLog() {}

//     // ✅ REQUIRED BY TicketCategorizationEngine
//     public CategorizationLog(Ticket ticket, Category category, String urgency) {
//         this.ticket = ticket;
//         this.category = category;
//         this.urgency = urgency;
//     }

//     public Long getId() {
//         return id;
//     }

//     public Ticket getTicket() {
//         return ticket;
//     }

//     public Category getCategory() {
//         return category;
//     }

//     public String getUrgency() {
//         return urgency;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Ticket ticket;
    
    @ManyToOne
    private CategorizationRule appliedRule;
    
    private String matchedKeyword;
    private String assignedCategory;
    private String assignedUrgency;
    private LocalDateTime loggedAt;

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public CategorizationRule getAppliedRule() { return appliedRule; }
    public void setAppliedRule(CategorizationRule appliedRule) { this.appliedRule = appliedRule; }
    public String getMatchedKeyword() { return matchedKeyword; }
    public void setMatchedKeyword(String matchedKeyword) { this.matchedKeyword = matchedKeyword; }
    public String getAssignedCategory() { return assignedCategory; }
    public void setAssignedCategory(String assignedCategory) { this.assignedCategory = assignedCategory; }
    public String getAssignedUrgency() { return assignedUrgency; }
    public void setAssignedUrgency(String assignedUrgency) { this.assignedUrgency = assignedUrgency; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
}