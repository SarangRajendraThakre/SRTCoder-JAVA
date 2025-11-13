package com.srt.service;

import org.springframework.stereotype.Service;

import com.srt.dto.UserSignUpDTO;

@Service
public class UserAccountService {

	
	public String userSignup(UserSignUpDTO userSignUpDTO)
	{
		return "User created succeefullyy";
	}
	
}
