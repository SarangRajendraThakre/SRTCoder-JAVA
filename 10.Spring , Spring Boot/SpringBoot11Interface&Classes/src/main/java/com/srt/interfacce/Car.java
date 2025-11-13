package com.srt.interfacce;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	@Override
	public String vehicleType() {
	  return "Car object";
	}

	
	
	
}
