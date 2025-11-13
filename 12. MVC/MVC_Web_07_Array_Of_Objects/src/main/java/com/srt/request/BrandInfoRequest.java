package com.srt.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class BrandInfoRequest {

	private String brandName;
	@Autowired
	private List<CarInfoRequest> carInfoRequest;
	
	
	
}
