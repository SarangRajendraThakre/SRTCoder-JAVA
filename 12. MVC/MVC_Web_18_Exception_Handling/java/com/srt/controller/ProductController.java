package com.srt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.ProductDetail;
import com.srt.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/add/product")
	public String addProduct(@Valid @RequestBody ProductDetail productDetail)
	{
		
		
		return productService.addProduct(productDetail);
	}
	
}
