package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot28GeneratedValuesApplication {

    public static void main(String[] args) {
        
        // 1. Start the Spring Boot container
        ConfigurableApplicationContext container = SpringApplication.run(SpringBoot28GeneratedValuesApplication.class, args);
        
        // 2. Retrieve the service bean
        DatabaseOperation databaseOperation = (DatabaseOperation) container.getBean("databaseOperation");
        // We use the DataInitializer to clean up and set up the initial data
        DataInitializer dataInitializer = (DataInitializer) container.getBean("dataInitializer");
        
        System.out.println("\n=======================================================");
        System.out.println("🚀 STARTING ONE-TO-MANY DEMO");
        System.out.println("=======================================================");
        
        // --- Note: The DataInitializer runs automatically and saves Dept ID 101 ---
        // --- We will demonstrate saving Dept ID 1 and then reading both. ---
        
        // 3. Save a new Department and Employees (using Dept ID 1)
        databaseOperation.saveOneToManyRelationship(); 

        // 4. Retrieve the entire graph (Dept ID 1) and demonstrate Lazy Loading
        databaseOperation.loadOneToManyRelationship(1); 
        
        // 5. Retrieve the graph created by the CommandLineRunner (Dept ID 101)
        databaseOperation.loadOneToManyRelationship(101); 
        
        // 6. Demonstrate Cascading Deletion
        databaseOperation.deleteDepartment(101);
        System.out.println("Verification: Attempting to load Dept 101 after delete...");
        databaseOperation.loadOneToManyRelationship(101); // Should print "Department not found"
        
        System.out.println("\n--- APPLICATION FINISHED ---");
        container.close(); 
    }
}