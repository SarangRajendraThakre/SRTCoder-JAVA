package com.srt.service;

import org.springframework.stereotype.Service;

import com.srt.request.ProductDetail;

@Service
public class ProductService {

	public String addProduct(ProductDetail productDetail) throws ClassNotFoundException {

		Integer priceInteger = null;
      
		System.out.println("Price is "+priceInteger);
		
		return "added successfully";
	}

	
	
	
}
