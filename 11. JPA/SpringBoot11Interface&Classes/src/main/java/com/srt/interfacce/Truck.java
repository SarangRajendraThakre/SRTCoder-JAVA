package com.srt.interfacce;

import org.springframework.stereotype.Component;

@Component
public class Truck implements Vehicle {

	@Override
	public String vehicleType() {
	  return "Truck object";
	}

	
	
	
}
