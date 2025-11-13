package com.srt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Scope("singleton")
@Component
public class Product {

	@Value("SRT")
	private String productName;

	
	
public Product() {
	System.out.println("product object created ");
}	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@PostConstruct
	public void logicOnAfterConstructionAndConfig()
	{
		System.out.println("Product object @PostConstruct");
	}
	@PreDestroy
	public void logicOnBeforeDestruction()
	{
		System.out.println("Product object @PostConstruct");
	}
	
	
	
}
