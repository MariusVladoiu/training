package com.wipro.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = StudentNotAvailableException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotFoundException(StudentNotAvailableException exception){
        Map<String, String> responseBody = new LinkedHashMap<>();
        responseBody.put("status_code", HttpStatus.NOT_FOUND.name());
        responseBody.put("message", exception.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}
