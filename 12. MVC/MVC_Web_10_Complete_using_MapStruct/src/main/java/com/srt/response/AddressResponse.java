package com.srt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponse {

	private String houseName;
	private String locality;
	private int pincode;
	private String city;
	private String state;
	private String country;
	
	
}
