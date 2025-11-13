package com.srt.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srt.dto.AddressDTO;
import com.srt.dto.UserSignUpDTO;
import com.srt.service.AddressService;
import com.srt.service.UserAccountService;


@RestController
@RequestMapping("/user")
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;

	@Autowired
	AddressService addressService;

	@GetMapping("/health")
	public String health() {
		return "working";
	}

	@PostMapping("/signup")
	public String userSignup(@RequestBody UserSignUpDTO userSignUpDTO) {

		// 1. Get the Logger instance
		Logger logger = LoggerFactory.getLogger(UserAccountController.class);

		// Log the attempt with the DTO's data (avoiding sensitive info like passwords)
		logger.info("Attempting user sign-up for email: {}", userSignUpDTO);

		String string = userAccountService.userSignup(userSignUpDTO);

		// 3. Return a response
		return string;
	}

	
//	<Address>
//    <houseNumber>365594</houseNumber>
//    <street>ganesh road</street>
//    <locality>harihar nagar</locality>
//    <city>wardha</city>
//    <state>maharashtra</state>
//    <country>india</country>
//</Address>
	
//	For xml it will not work , by default support to json 
	@PostMapping(path = "/createAddress" , consumes = MediaType.APPLICATION_XML_VALUE )
	public String addAddress(@RequestBody AddressDTO addressDTO) {

		Logger logger = LoggerFactory.getLogger(UserAccountController.class);
		logger.info("address logs : {}", addressDTO);

		String str = addressService.addAddress(addressDTO);

		return str;

	}
	
	// java object converted to xml by xml converter 
	// by default SB does not support xml converter 
	
	// both are same below 
//	@GetMapping(path = "/get/address" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/get/address")
	public AddressDTO  getAddress()
	{  
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setCity("pune");
		addressDTO.setCountry("IN");
		addressDTO.setHouseNumber(454);
		addressDTO.setLocality("palakwadi");
		addressDTO.setState("maharashtra");
		addressDTO.setStreet("undir patthi");
		
		
	return addressDTO;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
