package com.srt.service;

import org.springframework.stereotype.Service;

import com.srt.request.ProductDetail;

@Service
public class ProductService {

	public String addProduct(ProductDetail productDetail) {


		
		System.out.println("Price is ");
		
		return "added successfully";
	}

	
	
	
}
