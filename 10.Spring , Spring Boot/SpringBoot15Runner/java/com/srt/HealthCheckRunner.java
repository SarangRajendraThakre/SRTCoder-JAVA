package com.srt;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		  System.out.println("Health check Runner executed ");
	}


	
	

	
	
	
	
}
