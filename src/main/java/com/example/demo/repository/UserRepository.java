package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Test case line 583 requires findByEmail
    Optional<User> findByEmail(String email);

    // Test case lines 137, 156, and 373 require existsByEmail
    boolean existsByEmail(String email);
}