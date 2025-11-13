package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot28GeneratedValuesApplication {

	public static void main(String[] args) {
		
        // Start the Spring Boot container
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot28GeneratedValuesApplication.class, args);
		
        // Retrieve the service bean
        DatabaseOperation dbOps = container.getBean(DatabaseOperation.class);
        
        System.out.println("\n--- STARTING INSERT OPERATION DEMO ---");
        
        // Execute the insert logic
        dbOps.insertRecord();
        
        System.out.println("--- APPLICATION FINISHED ---");
        
        // Close the container gracefully
        container.close(); 
	}
}