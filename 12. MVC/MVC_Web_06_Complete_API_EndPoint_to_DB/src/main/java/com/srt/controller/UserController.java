package com.srt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srt.dto.UserDetailDTO;
import com.srt.request.UserLoginRequest;
import com.srt.response.LoginResponse;
import com.srt.service.LoginService;
import com.srt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;

	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDetailDTO userDetailDTO) {

		String response = userService.createUser(userDetailDTO);

		return response;

	}
	
	@PostMapping("/login")
	public  LoginResponse  userLogin(@RequestBody UserLoginRequest userLoginRequest  )
	{
		
	  LoginResponse loginResponse =  	loginService.login(userLoginRequest);
	    
	  return loginResponse;
		
	}

	

}
