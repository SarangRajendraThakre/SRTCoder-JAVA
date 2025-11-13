package com.srt.setterInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SetterBeansConfiguration {

	@Bean
	public Address getAddress() {
		
		Address address  = new Address();
		System.out.println("getAddress object created and initialized");
		address.setCity("New York");
		address.setPincode(999999);
		
		return address;
				
	}
	
	
	@Bean("address1")
	public Address getAddress2() {
		Address address  = new Address();
		System.out.println("address2 object created and initialized");
		address.setCity("Deccan GymKhana");
		address.setPincode(411004);
		
		return address;
	}
	
//	@Bean("address3")
//	public Address getAddress3() {
//		
//		Address address  = new Address();
//		System.out.println("address3 object created and initialized");
//		address.setCity("Hinjewadi");
//		address.setPincode(411033);
//		
//		return address;
//	}
	
}
