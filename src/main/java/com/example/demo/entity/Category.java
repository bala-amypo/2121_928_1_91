package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    private String description;

    @Column(nullable = false)
    private String defaultUrgency;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "assignedCategory")
    private List<Ticket> tickets;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDefaultUrgency() { return defaultUrgency; }
    public void setDefaultUrgency(String defaultUrgency) { this.defaultUrgency = defaultUrgency; }
}
