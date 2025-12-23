package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception ex) {
        ex.printStackTrace(); // 🔥 shows real error in console
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }
}
