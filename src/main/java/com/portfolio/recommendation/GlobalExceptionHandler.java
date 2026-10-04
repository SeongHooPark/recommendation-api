package com.portfolio.recommendation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();

        for (String field : List.of("name", "relation", "content")) {
            FieldError error = e.getBindingResult().getFieldError(field);
            if (error != null) {
                messages.add(error.getDefaultMessage());
            }
        }

        return ResponseEntity.badRequest().body(Map.of("message", String.join("\n", messages)));
    }
}
