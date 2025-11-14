package com.srt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.Product;
import com.srt.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


//@RestController  instead 
@Controller
public class GraphQlController {
	
	@Autowired
	ProductService productService;
	
	
//	@GetMapping("/get/product")
	@QueryMapping
	public List<Product> getProduct() {
		
		return productService.getProducts();
	}
	
//	@GetMapping("/get/product/{category}")
	@QueryMapping
	
	public List<Product> getProductByCategory(@Argument  String category) {
		
		return productService.getByCategory(category);
	}
	
	@MutationMapping
	public Product updatePrice(@Argument int id , @Argument float price )
	{
		return productService.updatePrice(id, price);
	}
	
	@MutationMapping
	public Product updateNewShipment(@Argument int id , @Argument int stock )
	{
		return productService.newShippment(id, stock);
	}
	
	
}
