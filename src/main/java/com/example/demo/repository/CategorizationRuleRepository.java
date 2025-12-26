package com.example.demo.repository;

import com.example.demo.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {
    
    // This allows you to find all rules linked to a specific category ID
    List<CategorizationRule> findByCategoryId(Long categoryId);
}