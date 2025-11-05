package com.srt.byName;

import org.springframework.context.ApplicationContext;

public class BeanAutoWiringTest {

	public static void main(String[] args) {
	

		ApplicationContext container = new FileSystemXmlApplicationContext("E:\\SRTCoder JAVA\\10.Spring  , Spring Boot\\Spring6CreatingMavenProject\\spring-bean-byName.xml");
		Order o1 = (Order) container.getBean("order");
		
		Cart cart = o1.getCart();
		
		System.out.println(cart.getProduct1().getProductName());
		System.out.println(cart.getProduct1().getProductPrice());
		System.out.println(cart.getProduct2().getProductName());
		System.out.println(cart.getProduct2().getProductPrice());
		
		
	
		
		  
		
		
		
		
	}

}
