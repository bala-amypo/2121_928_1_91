// package com.example.demo.controller;

// import com.example.demo.model.UrgencyPolicy;
// import com.example.demo.service.UrgencyPolicyService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/policies")
// public class UrgencyPolicyController {

//     private final UrgencyPolicyService service;

//     public UrgencyPolicyController(UrgencyPolicyService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public UrgencyPolicy create(@RequestBody UrgencyPolicy policy) {
//         return service.createPolicy(policy);
//     }

//     @GetMapping("/{id}")
//     public UrgencyPolicy get(@PathVariable Long id) {
//         return service.getPolicy(id);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.service.impl.UrgencyPolicyServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@Tag(name = "Policies")
public class UrgencyPolicyController {
    private final UrgencyPolicyServiceImpl policyService;

    public UrgencyPolicyController(UrgencyPolicyServiceImpl policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<UrgencyPolicy> createPolicy(@RequestBody UrgencyPolicy policy) {
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }

    @GetMapping
    public ResponseEntity<List<UrgencyPolicy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
}