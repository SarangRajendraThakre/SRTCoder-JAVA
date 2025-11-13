package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot28GeneratedValuesApplication {

	public static void main(String[] args) {
		
        // Start the Spring Boot container
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot28GeneratedValuesApplication.class, args);
		
	DatabaseOperation databaseOperation = 	(DatabaseOperation) container.getBean("databaseOperation");
		
//	databaseOperation.addEmployee();
	databaseOperation.deleteEmployeeById();
//	databaseOperation.findByAddressJoin();

	databaseOperation.findByAddressJoinDerived();
	
	}
}