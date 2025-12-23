package com.example.demo.service;

import com.example.demo.model.UrgencyPolicy;

public interface UrgencyPolicyService {
    UrgencyPolicy create(UrgencyPolicy policy);
    UrgencyPolicy get(Long id);
}
