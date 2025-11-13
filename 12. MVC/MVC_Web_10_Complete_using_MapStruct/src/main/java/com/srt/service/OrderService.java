package com.srt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srt.entities.OrderInfoEntity;
import com.srt.repository.OrderRepository;
import com.srt.request.OrderInfoRequest;
import com.srt.response.OrderInfoResponse;

@Service
public class OrderService {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository; 
    
    // 1. INJECT THE MAPSTRUCT MAPPER
    @Autowired 
    private OrderMapper orderMapper; 

    @Transactional
    public OrderInfoResponse createOrder(OrderInfoRequest orderInfoRequest) { 

        logger.info("Starting order creation for user: {}", orderInfoRequest.getFirstName());
        
        try {
            // 2. USE MAPPER TO CONVERT DTO TO ENTITY
            OrderInfoEntity orderInfoEntity = orderMapper.toEntity(orderInfoRequest);

            // 3. Save the Entity (Business Logic)
            logger.info("Attempting to save OrderInfoEntity...");
            OrderInfoEntity savedOrder = orderRepository.save(orderInfoEntity);
            logger.info("✅ Order successfully saved with ID: {}", savedOrder.getOrderId());
            
            
            // 4. USE MAPPER TO CONVERT ENTITY BACK TO RESPONSE DTO
            OrderInfoResponse finalResponse = orderMapper.toResponse(savedOrder);
            
            return finalResponse;
            
        } catch (Exception e) {
            logger.error("❌ FATAL ERROR: Order creation failed and transaction will be rolled back.", e);
            throw new RuntimeException("Order creation failed due to: " + e.getMessage(), e); 
        }
    }

 
    
    // Fix the method signature to return a List of Response DTOs
    @Transactional(readOnly = true) // Use readOnly for GET requests
    public List<OrderInfoResponse> getOrders() {
		  
		// 1. Fetch the list of Entities from the database
		List<OrderInfoEntity> orderInfoEntities = orderRepository.findAll();
		
		// 2. Use MapStruct (via a custom stream operation) to convert the List of Entities to a List of DTOs
        // MapStruct usually handles the list conversion automatically if you pass the entire list, 
        // but stream is often clearer for filtering or optional safety.
        return orderInfoEntities.stream()
            .map(orderMapper::toResponse) // Use the existing toResponse method from the mapper
            .collect(Collectors.toList());
	}
}