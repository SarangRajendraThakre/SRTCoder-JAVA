package com.srt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeApplication {
 public static void main(String[] args) {


	 ApplicationContext container = new AnnotationConfigApplicationContext(BeanConfiguration.class)  ;
	 
    
	 Student s1 = (Student) container.getBean("student");
	 
	 
	 System.out.println(s1.getAddress().getCity());
	 System.out.println(s1.getAddress().getPincode());
 
    
 }
}