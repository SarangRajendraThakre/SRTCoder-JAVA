package com.srt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.srt.dto.AddressDTO;

@Service
public class AddressService {

	
	public String addAddress(AddressDTO  addressDTO)
	{
   Logger logger =		LoggerFactory.getLogger(AddressService.class);
		
//   logger.info("address logs ", addressDTO);
		return "address added successfully";
		
	}
	
}
