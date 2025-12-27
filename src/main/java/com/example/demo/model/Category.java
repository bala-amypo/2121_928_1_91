// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String categoryName;
//     private String defaultUrgency;

//     public Category() {}

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     // ✅ REQUIRED BY TESTS
//     public String getCategoryName() {
//         return categoryName;
//     }

//     // ✅ REQUIRED BY TESTS
//     public void setCategoryName(String categoryName) {
//         this.categoryName = categoryName;
//     }

//     public String getDefaultUrgency() {
//         return defaultUrgency;
//     }

//     public void setDefaultUrgency(String defaultUrgency) {
//         this.defaultUrgency = defaultUrgency;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String defaultUrgency;
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "category_policies",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "policy_id")
    )
    private Set<UrgencyPolicy> urgencyPolicies = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDefaultUrgency() { return defaultUrgency; }
    public void setDefaultUrgency(String defaultUrgency) { this.defaultUrgency = defaultUrgency; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Set<UrgencyPolicy> getUrgencyPolicies() { return urgencyPolicies; }
    public void setUrgencyPolicies(Set<UrgencyPolicy> urgencyPolicies) { this.urgencyPolicies = urgencyPolicies; }
}