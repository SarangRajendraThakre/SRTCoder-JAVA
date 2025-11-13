package com.srt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeApplication {
 public static void main(String[] args) {


	 ApplicationContext container = new  FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot , JPA\\Spring04ConstructorInjection\\spring.xml");
	 
	 
	 Object object = container.getBean("employee1");
	 
	 Employee employee = (Employee)object;
	 
	 System.out.println(employee);
	 
	 
	 
	
	 
	
	 
    
 
    
 }
}