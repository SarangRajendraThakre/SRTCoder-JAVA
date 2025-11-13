package com.srt.request;

import lombok.Data;

@Data
public class AddressResquest {
	
	private String		houseNumber;
	private String		locality;
	private int		pincode;
	private String		state;
	private String		country;
}