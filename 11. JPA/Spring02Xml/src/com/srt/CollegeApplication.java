package com.srt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CollegeApplication {
 public static void main(String[] args) {


	 ApplicationContext container = new  FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot , JPA\\Spring02Xml\\spring.xml");
	 
	 
	 
    Object object =  container.getBean("address1");
    
    Address a1 = (Address) object;
    
    
    Object object2 = container.getBean("student1");
    
    Student s1 = (Student) object2;
    
    System.out.println(s1.getName());
    System.out.println(s1.getAddress());
    
    
 
    
 }
}