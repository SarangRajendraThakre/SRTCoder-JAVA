package com.srt.Constructor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanAutoWiringTest {

	public static void main(String[] args) {
	

		ApplicationContext container = new FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot\\Spring5bean_AutoWiring\\spring-bean-constructor.xml");
	
	  Hospital h1 = 	(Hospital) container.getBean("hospital");
	  
	  System.out.println(h1.getDoctor());
	  System.out.println(h1.getPatient());
		
		
		
	
		
	
		
		  
		
		
		
		
	}

}
