// package com.example.demo.service.impl;

// import com.example.demo.model.UrgencyPolicy;
// import com.example.demo.repository.UrgencyPolicyRepository;
// import org.springframework.stereotype.Service;

// @Service
// public class UrgencyPolicyServiceImpl {

//     private final UrgencyPolicyRepository repository;

//     public UrgencyPolicyServiceImpl(UrgencyPolicyRepository repository) {
//         this.repository = repository;
//     }

//     public UrgencyPolicy save(UrgencyPolicy policy) {
//         return repository.save(policy);
//     }

//     public UrgencyPolicy getById(Long id) {
//         return repository.findById(id).orElse(null);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import org.springframework.stereotype.Service;

@Service
public class UrgencyPolicyServiceImpl {
    private final UrgencyPolicyRepository policyRepository;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public UrgencyPolicy createPolicy(UrgencyPolicy policy) {
        return policyRepository.save(policy);
    }

    public UrgencyPolicy getPolicy(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));
    }
}