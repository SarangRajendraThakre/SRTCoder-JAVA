package com.srt.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.ProductDetail;
import com.srt.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class ProductController {


	ProductService productService;
	
	@PostMapping("/add/product")
	public String addProduct(@Valid @RequestBody ProductDetail productDetail) throws ClassNotFoundException
	{
		
		
		return productService.addProduct(productDetail);
	}
	
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
                "Sorry, We are Experiencing Some Issues. Please Try after some time. from the Product Controller"
            ));
    }
	
}
