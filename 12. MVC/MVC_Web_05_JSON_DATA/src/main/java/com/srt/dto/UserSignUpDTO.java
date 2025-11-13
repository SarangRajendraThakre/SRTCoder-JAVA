package com.srt.dto;

import lombok.Data;

@Data
public class UserSignUpDTO {

	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private String password;
	private int    age;
	
}
