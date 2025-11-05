package com.srt;

import org.springframework.stereotype.Component;

@Component
public class Address {

  private String city;
  private int pincode ;
  

  public Address() {
	// TODO Auto-generated constructor stub
}
  
  public Address(String city, int pincode) {
	super();
	
	System.out.println("address object created");
	this.city = city;
	this.pincode = pincode;
}
  
  
  public String getCity() {
	return city;
  }
  public void setCity(String city) {
	this.city = city;
  }
  public int getPincode() {
	return pincode;
  }
  public void setPincode(int pincode) {
	this.pincode = pincode;
  }
  
  
	
}
