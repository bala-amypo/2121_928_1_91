package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent())
            throw new BadRequestException("Email already in use");
        return repo.save(user);
    }

    public User get(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
