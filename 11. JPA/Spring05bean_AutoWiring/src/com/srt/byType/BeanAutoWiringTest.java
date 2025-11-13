package com.srt.byType;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanAutoWiringTest {

	public static void main(String[] args) {
	

		ApplicationContext container = new FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot , JPA\\Spring05bean_AutoWiring\\spring-bean-byType.xml");
		
		
     College  c1 = 	(College)container.getBean("college");
		
		System.out.println(c1.getStudent());  
		
		
		
		
	}

}
