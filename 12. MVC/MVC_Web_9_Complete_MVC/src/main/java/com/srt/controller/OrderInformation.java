package com.srt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; // <-- Needed for injection
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.OrderInfoRequest;
import com.srt.response.OrderInfoResponse;
import com.srt.service.OrderService; // <-- Import the service

@RestController
public class OrderInformation {
	
    // 1. Inject the OrderService dependency
    @Autowired
    private OrderService orderService; // <-- Add this field
	
    // Use the specific logger for this class
    private static final Logger logger = LoggerFactory.getLogger(OrderInformation.class);
	
    @PostMapping("/createOrder")
    public OrderInfoResponse createOrder(@RequestBody OrderInfoRequest orderInfoRequest ) {
        
        // Use the specific logger instance
        logger.info("order info {}", orderInfoRequest);
        
        // 2. CALL THE SERVICE METHOD to perform the business logic (saving data)
        OrderInfoResponse response = orderService.createOrder(orderInfoRequest); // <-- Add this call
        
        return response; // Return the response from the service
    }
}