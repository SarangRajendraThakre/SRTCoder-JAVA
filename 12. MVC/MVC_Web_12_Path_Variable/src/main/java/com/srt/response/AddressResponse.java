package com.srt.response;

import lombok.Data;

@Data
public class AddressResponse {
	
	private String		houseNumber;
	private String		locality;
	private int		pincode;
	private String		state;
	private String		country;
}