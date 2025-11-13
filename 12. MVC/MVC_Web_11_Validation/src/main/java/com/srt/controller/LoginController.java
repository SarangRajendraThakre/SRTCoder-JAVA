package com.srt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.LoginRequest;
import com.srt.request.LoginRequest2;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class LoginController {

	// without validation , you are able to pass the data
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return "login successsful";
	}

	// with validation , you are able to pass the data
	@PostMapping("/login/v2")
	public String login2(@RequestBody @Valid LoginRequest2 loginRequest2) {
		return "login successsful";
	}
	
	

}
