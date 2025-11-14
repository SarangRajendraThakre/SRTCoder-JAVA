package com.srt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srt.repository.ProductRepositoty;
import com.srt.request.Product;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MvcWeb32GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcWeb32GraphqlApplication.class, args);
	}

	  @Autowired
    private ProductRepositoty repository;

    /**
     * Initializes the database with sample products after the bean is constructed.
     */
    @PostConstruct
    public void initDB() {
        
        // Note: Assuming the Product constructor is (name, category, price, stockQuantity)
        List<Product> products = Stream.of(
            new Product("Laptop", "Electronics", 74999.99f, 50),
            new Product("Smartphone", "Electronics", 39999.99f, 100),
            new Product("Office Chair", "Furniture", 7999.99f, 200),
            new Product("Notebook", "Stationery", 99.99f, 500),
            new Product("Desk Lamp", "Furniture", 1999.99f, 150),
            new Product("Water Bottle", "Accessories", 499.99f, 300)
        ).collect(Collectors.toList());

        // Saves all the generated products to the database
        repository.saveAll(products);
        System.out.println("Database initialization complete. Added " + products.size() + " products.");
    }
	
}
