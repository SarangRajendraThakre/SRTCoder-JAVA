package com.srt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.srt")
@Configuration
public class BeanConfiguration {

	@Bean("address1")
	public Address getAddress() {
		
		
		return  new Address("pune" , 12321);
		
	}
	
	
	
}
