package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot31ManyToMany {

    public static void main(String[] args) {
        
        // 1. Start the Spring Boot container
        ConfigurableApplicationContext container = SpringApplication.run(SpringBoot31ManyToMany.class, args);
        
        // 2. Retrieve the service bean (DatabaseOperation)
        DatabaseOperation dbOps = container.getBean(DatabaseOperation.class);
        
        System.out.println("\n==================================================");
        System.out.println("🔄 STARTING MANY-TO-MANY ENROLLMENT DEMO");
        System.out.println("==================================================");
        
        // 3. Execute the core logic
        // This method performs setup, saving, and printing verification results.
        dbOps.runManyToManyDemo(); 
        
        System.out.println("\n--- APPLICATION FINISHED ---");
        
        // 4. Close the container gracefully
        container.close(); 
    }
}