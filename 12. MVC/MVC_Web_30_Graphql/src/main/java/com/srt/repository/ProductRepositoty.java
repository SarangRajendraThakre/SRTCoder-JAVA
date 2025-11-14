package com.srt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.request.Product;

public interface ProductRepositoty extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String catg);

	
	
}
