package com.srt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeApplication {
 public static void main(String[] args) {


	 ApplicationContext container = new  FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot\\Spring6creationOfMavenSpringProject\\spring.xml");
	 
	 Object object = container.getBean("employee1");
	 
	 Employee e1 = (Employee) object;
	 
	 System.out.println(e1.getEmpno());
	 System.out.println(e1.getName());
	 System.out.println(e1.getPhoneNo());
	 
	 System.out.println(e1.getAddress().getCity());
	 System.out.println(e1.getAddress().getPincode());
	 
	 System.out.println(e1.getPllist().size());

	 
	 System.out.println(e1);
    
 
    
 }
}