package com.srt.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.OrderInfoRequest;

@RestController
public class OrderInformation {
	
	
@PostMapping("/createOrder")
	public String createOrder(@RequestBody OrderInfoRequest orderInfoRequest )
	{
	
    Logger logger =  LoggerFactory.getLogger(RestController.class);
    
    logger.info("order info {}",orderInfoRequest);
    
		return "order created successfully";
		
	}
	
	
}
