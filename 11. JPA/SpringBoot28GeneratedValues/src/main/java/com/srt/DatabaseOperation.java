package com.srt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseOperation {
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	/**
	 * Creates a new entity using the no-arg constructor, signaling to JPA that the ID must be generated.
	 */
	public void insertRecord() {
		
        // 1. Create a new entity instance (orderId is null initially)
		OrdersTable newOrder = new OrdersTable(); 
		
        // 2. Set the data fields
		newOrder.setAddress("Wardha, Maharashtra"); 
		
        // 3. Save: Hibernate runs the sequence and inserts the record.
        // The savedOrder object now contains the generated ID.
		OrdersTable savedOrder = orderDetailsRepository.save(newOrder);
		
		System.out.println("✅ New Order saved successfully!");
		System.out.println("Generated ID received back: " + savedOrder.getOrderId());
		System.out.println("Address: " + savedOrder.getAddress());
	}
}