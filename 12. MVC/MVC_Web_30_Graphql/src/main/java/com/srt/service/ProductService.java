package com.srt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srt.repository.ProductRepositoty;
import com.srt.request.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepositoty productRepositoty;

	public List<Product> getProducts() {
		return productRepositoty.findAll();
	}

	public List<Product> getByCategory(String catg) {
		return productRepositoty.findByCategory(catg);
	}

	public Product updatePrice(int id, Float price) {
		Product product = productRepositoty.findById(id).orElseThrow(() -> new RuntimeException());

		product.setPrice(price);
		return productRepositoty.save(product);

	}
	public Product newShippment(int id, int  stock) {
		Product product = productRepositoty.findById(id).orElseThrow(() -> new RuntimeException());
		
		product.setStock(product.getStock()+stock);
		return productRepositoty.save(product);
		
	}

}
