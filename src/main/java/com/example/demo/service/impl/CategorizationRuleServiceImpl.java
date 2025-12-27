// package com.example.demo.service.impl;

// import com.example.demo.model.CategorizationRule;
// import com.example.demo.repository.CategorizationRuleRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CategorizationRuleServiceImpl {

//     private final CategorizationRuleRepository repository;

//     public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
//         this.repository = repository;
//     }

//     public CategorizationRule createRule(CategorizationRule rule) {
//         return repository.save(rule);
//     }

//     public List<CategorizationRule> getRulesByKeyword(String keyword) {
//         return repository.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategorizationRuleServiceImpl {
    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository, 
                                         CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }
    // Additional methods can be added as needed by controllers
}