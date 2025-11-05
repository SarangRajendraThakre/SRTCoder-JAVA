package com.srt;

import org.springframework.stereotype.Component;

//@Component(value = "address")
@Component("address")
public class Address {

	private String city;
	private int houseNo;
	
	public Address() {
		// TODO Auto-generated constructor stub
		System.out.println("Address object created");
	}
	
	
	
	public Address(String city, int houseNo) {
		super();
		System.out.println("Address object with parameter created");
		this.city = city;
		this.houseNo = houseNo;
	}



	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	
	
}
