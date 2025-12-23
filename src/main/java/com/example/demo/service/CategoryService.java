package com.example.demo.service;

import com.example.demo.model.Category;

public interface CategoryService {
    Category create(Category category);
    Category get(Long id);
}


package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import java.util.List;
public interface CategorizationLogService {
    CategorizationLog create(CategorizationLog log);
    CategorizationLog get(Long id);
    List<CategorizationLog> getByTicket(Long ticketId);
}
