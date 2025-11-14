package com.srt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldError> errors = ex.getFieldErrors();

        Map<String, String> errorsMap = errors.stream().collect(
            Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage,
                (existing, replacement) -> existing // prevent duplicate key crash
            )
        );

        return ResponseEntity.badRequest().body(errorsMap);
    }
    
    /**
     * Handles NullPointerException and returns HTTP 500 Internal Server Error.
     * This is used for unexpected errors that should be fixed by the developer.
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        
        // Log the exception details for debugging purposes
        System.err.println("NullPointerException caught in global handler: " + ex.getMessage());
        ex.printStackTrace();
        
        // Return a generic, safe error message to the client
        return ResponseEntity
            .internalServerError() // HTTP Status 500
            .body(Collections.singletonMap(
                "error", 
                "Sorry, We are Experiencing Some Issues. Please Try after some time."
            ));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e)
    {
    	return ResponseEntity.internalServerError().body("intenal server error");
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
