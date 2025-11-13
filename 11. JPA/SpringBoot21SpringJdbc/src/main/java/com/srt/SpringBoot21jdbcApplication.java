package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot21jdbcApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext container =   	SpringApplication.run(SpringBoot21jdbcApplication.class, args);
	  
	 DatabaseOperations  dOperations =  (DatabaseOperations) container.getBean("databaseOperations");
	 
//	 dOperations.createProductTable();
//	 dOperations.addProduct();
	 
//	 dOperations.deleteProduct();
	 
	dOperations.saveProduct();
//	 dOperations.loadAllProduct();
	
	} 

}
