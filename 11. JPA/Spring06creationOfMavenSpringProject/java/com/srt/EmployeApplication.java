package com.srt;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.srt.data.DatabaseOperations;

@Configuration
@ComponentScan("com.srt") // Ensure your components are scanned
public class EmployeApplication {
 public static void main(String[] args) {


	  ConfigurableApplicationContext container = new AnnotationConfigApplicationContext(DatabaseOperations.class);
	 
	 DatabaseOperations dbo =  (DatabaseOperations) container.getBean("databaseOperations");
	 

	  dbo.getAllEmployees();
	 
	 
	 
    
 
    
 }
}