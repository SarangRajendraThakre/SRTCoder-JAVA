package com.srt.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.srt.config.SecurityConfiguration;
import com.srt.request.UserInfoRequest;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserManagementController {

    private final SecurityConfiguration securityConfiguration;

    UserManagementController(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

//	1. Request Headers:
//
//		headers which are sent or part of along with Request called as Request headers.
//
//		Content-Type : Data Type of Request Body sent by cleint to server.
//
//		application/xml, application/json
//
//		Accept : Data Type of Response accepted by cleint.

//	2. Response Headers:
//
//		headers which are sent or part of along with Response called as Response headers.
//
//		Pre-Defined Headers : HTTP Protocol by default

	// without RequestHeader

//	@GetMapping("/get/{emailId}")
//	public UserInfoRequest loadUserByEmail(@PathVariable String emailId )
//	{
//		// service layer 
//		// response layer 
//		
//		return new UserInfoRequest("sarang", "sarangyvt9@gamil.com", "Sarang@123");
//		
//	}

//	using the names of token in ""

//	@GetMapping("/get/{emailId}")
//	public UserInfoRequest loadUserByEmail(
//	    @PathVariable String emailId, 
//	    @RequestHeader("security-token") String securityToken // CORRECTED: Renamed variable and fixed annotation
//	) {
//	    // service layer 
//	    // response layer 
//	    
//	    Logger logger = LoggerFactory.getLogger(UserManagementController.class);
//	    // Use the correctly named variable
//	    logger.info("Security Token Received: {}", securityToken); 
//	    
//	    // In a real application, this would fetch user data.
//	    return new UserInfoRequest("sarang", "sarangyvt9@gamil.com", "Sarang@123");
//	}
//	

// not 	using the names of token in "", by default same as method variable 

//	@GetMapping("/get/{emailId}")
//	public UserInfoRequest loadUserByEmail(
//	    @PathVariable String emailId, 
//	    @RequestHeader String securityToken 
//	) {
//	    // service layer 
//	    // response layer 
//	    
//	    Logger logger = LoggerFactory.getLogger(UserManagementController.class);
//	    // Use the correctly named variable
//	    logger.info("Security Token Received: {}", securityToken); 
//	    
//	    // In a real application, this would fetch user data.
//	    return new UserInfoRequest("sarang", "sarangyvt9@gamil.com", "Sarang@123");
//	}
//	

	@GetMapping("/get/{emailId}")
	public UserInfoRequest loadUserByEmail(@PathVariable String emailId, @RequestHeader String securityToken,

			HttpServletRequest request

	) {
		// service layer
		// response layer

		// getting the other headers data using the HttpservletRequest

		System.out.println("Getting the header by name " + request.getHeader("Accept"));

		Logger logger = LoggerFactory.getLogger(UserManagementController.class);
		// Use the correctly named variable
		logger.info("Security Token Received: {}", securityToken);

		// In a real application, this would fetch user data.
		return new UserInfoRequest("sarang", "sarangyvt9@gamil.com", "Sarang@123");
	}
	
	// by default @RequestHeader is required is true  , we can make it false , then in that case default value wee can set
	@GetMapping("/get/v2/{emailId}")
	public UserInfoRequest loadUserByEmailV2(@RequestHeader(required =  false , defaultValue = "thissisdefaulvalue") String securityToken   ,    @PathVariable String emailId ) {
		
		
	  Logger logger  =	LoggerFactory.getLogger(getClass());
	  logger.info(securityToken);
		
		return new UserInfoRequest("yadnesh", "yadnesh@gmail.com", "Yadnesh@123");
	}
	
	
	
	
	// ResponseHeader  
	
//	to send the token whileing login we use 
	
	
	@GetMapping("/get/token")
    public ResponseEntity<UserInfoRequest> tokenSending(@RequestBody UserInfoRequest userInfoRequest) {
        
        // 1. Create the custom headers
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        // Use a standard HTTP header name, typically starting with 'X-' for custom headers 
        // or a known header like 'Authorization', but here we use a custom one for example.
        responseHttpHeaders.add("access-token234", UUID.randomUUID().toString());
        responseHttpHeaders.add("sarangtoken", UUID.randomUUID().toString());
        
        // 2. Create the response body object
        UserInfoRequest responseBody = new UserInfoRequest("sarang", "srt", "asfdjasdf");
        
        // 3. Wrap the body, headers, and HTTP status (e.g., HttpStatus.OK = 200) into a ResponseEntity
        return new ResponseEntity<>(responseBody, responseHttpHeaders, HttpStatus.OK);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
