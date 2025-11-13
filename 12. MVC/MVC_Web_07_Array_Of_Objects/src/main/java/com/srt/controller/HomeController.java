package com.srt.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.config.SecurityConfiguration;
import com.srt.request.BrandInfoRequest;
import com.srt.request.CarInfoRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



// this is the array of List<String> example 	
//	req : having the car brand names more then one skoda toyota bmw ...
	@PostMapping("/get/cars")
	public String createCarList(@RequestBody List<String> carNames) {

		Logger logger = LoggerFactory.getLogger(HomeController.class);
		logger.info("car Names {}", carNames);

//		System.out.println(carNames);

		return "Got all card ino";

	}

	// Array of Object example
	// List<CarInfo>
	// BrandInfo Class
	// String brandName;
	// List<CarInfo> carlist;

	// Array of Object example
	@PostMapping("/get/carList")
	public String getCarList(@RequestBody List<CarInfoRequest> carInfoRequest) {

		Logger logger = LoggerFactory.getLogger(HomeController.class);

		// 💡 FIX: Added the necessary catch block to complete the TryStatement
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonOutput = mapper.writeValueAsString(carInfoRequest);
			logger.info("Car Info List: {}", jsonOutput);
		} catch (Exception e) {
			// If logging fails, log the error and continue, but don't break the controller
			// logic
			logger.error("Error logging request data: Could not convert CarInfoRequest list to JSON.", e);
		}

		carInfoRequest.forEach(System.out::println);

		return "data receieve";

	}
	@PostMapping("/get/brandInfo")
	public String getBrandInfo(@RequestBody BrandInfoRequest brandInfoRequest) {
		
		Logger logger = LoggerFactory.getLogger(HomeController.class);
		
		// 💡 FIX: Added the necessary catch block to complete the TryStatement
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonOutput = mapper.writeValueAsString(brandInfoRequest);
			logger.info("Car Info List: {}", jsonOutput);
		} catch (Exception e) {
			// If logging fails, log the error and continue, but don't break the controller
			// logic
			logger.error("Error logging request data: Could not convert CarInfoRequest list to JSON.", e);
		}
		
//		brandInfoRequest.forEach(System.out::println);  this will not work here beacuse it is not list
		
		return "data receieve";
		
	}

}
