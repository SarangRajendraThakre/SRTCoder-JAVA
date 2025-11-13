package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot22JpaApplication {

	public static void main(String[] args) {
  ConfigurableApplicationContext container = 		SpringApplication.run(SpringBoot22JpaApplication.class, args);
	
 DatabaseOperation dbo =  (DatabaseOperation) container.getBean("databaseOperation");
 
 // adding one product at time 
//   dbo.addProductInformation();
 
// dbo.addAllProductInformation();
// dbo.loadAllProduct();
	
	}

}
