package com.srt.setterInjection;

import org.springframework.stereotype.Component;

@Component("address")
public class Address {

  private String city="wardha";
  private int pincode=442001 ;
  
  
  public Address() {
	  System.out.println("Address objected created no arg const..");
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
