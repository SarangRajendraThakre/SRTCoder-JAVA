package com.srt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class DatabaseOperation {

	@Autowired
	ProductDetailRepository productDetailRepository;

	
	
	public void addProductInformation() {
		ProductDetails pd = new ProductDetails(6, "Laptop", 10.0);
		productDetailRepository.save(pd);
        System.out.println("Single product added.");
	}
	
	public void addAllProductInformation() {
		List<ProductDetails> listProductDetails = new ArrayList<>();
		listProductDetails.add(new ProductDetails(10, "Fortuner", 54564.0));
		listProductDetails.add(new ProductDetails(11, "Flat", 43444.0));
		listProductDetails.add(new ProductDetails(12, "kawasaki", 34544.0));
		
		productDetailRepository.saveAll(listProductDetails);
        System.out.println("Batch products added.");
	}
    
    // --- Retrieval Methods ---

    public void loadProductById(int id) {
        Optional<ProductDetails> optionalPd = productDetailRepository.findById(id);
        optionalPd.ifPresentOrElse(
            pd -> System.out.println("Found ID " + pd.getProductID() + ": " + pd.getProductName()),
            () -> System.out.println("Product with ID " + id + " not found.")
        );
    }
    
    public void loadAllProducts() {
        // JpaRepository's findAll() returns a List
        List<ProductDetails> all = productDetailRepository.findAll();
        System.out.println("\n--- All Products (" + all.size() + ") ---");
        all.forEach(pd -> System.out.println(pd.getProductID() + " | " + pd.getProductName()));
    }
    
    public void checkExistence(int id) {
        boolean exists = productDetailRepository.existsById(id);
        System.out.println("Product ID " + id + " exists: " + exists);
    }

    public void countProducts() {
        long count = productDetailRepository.count();
        System.out.println("Total products in table: " + count);
    }
    
    // --- Deletion Methods ---

    public void deleteProductById(int id) {
        productDetailRepository.deleteById(id);
        System.out.println("Deleted product with ID: " + id);
    }
    
    public void deleteAllProducts() {
        System.out.println("Deleting all records...");
        productDetailRepository.deleteAll();
    }
    
    
 // --- PAGINATION & SORTING ---

    /**
     * Demonstrates findAll(Sort sort) to retrieve all records in a specific order.
     */
    public void loadAllProductsSorted() {
        // 1. Create a Sort object: Sort by 'productName' ascending
        Sort sortByName = Sort.by("productName").ascending();
        
        // 2. Execute the query
        List<ProductDetails> sortedList = productDetailRepository.findAll(sortByName);
        
        System.out.println("\n--- 🔠 Sorted Products (by Name) ---");
        sortedList.forEach(pd -> System.out.println(pd.getProductName() + " | Price: " + pd.getProductPrice()));
    }

    /**
     * Demonstrates findAll(Pageable pageable) to fetch data in pages.
     */
    public void loadProductsByPage(int pageNum, int pageSize) {
        // 1. Create a Pageable object: Request page N, with Y items, sorted by price DESC
        Pageable pageRequest = PageRequest.of(
            pageNum, 
            pageSize, 
            Sort.by("productPrice").descending()
        );
        
        // 2. Execute the paged query
        Page<ProductDetails> productPage = productDetailRepository.findAll(pageRequest);
        
        System.out.println("\n--- 📄 Page " + (pageNum + 1) + " of " + productPage.getTotalPages() + " ---");
        System.out.println("Total Records Found: " + productPage.getTotalElements());
        
        // 3. Process the content of the current page
        productPage.getContent().forEach(pd -> System.out.println(
            pd.getProductID() + " | " + pd.getProductName() + " | " + pd.getProductPrice()
        ));
    }
    
    // --- TRANSACTION SYNCHRONIZATION ---

    /**
     * Demonstrates saveAndFlush() to ensure immediate database write.
     * Requires @Transactional on the calling method or service.
     */
    @Transactional // Ensures a transaction is active for JPA operations
    public ProductDetails saveProductAndFlush(ProductDetails pd) {
        // saveAndFlush ensures the INSERT/UPDATE SQL is committed immediately 
        // (before the end of the transaction)
        ProductDetails savedEntity = productDetailRepository.saveAndFlush(pd);
        System.out.println("⚡ Saved and Flushed immediately: " + savedEntity.getProductName());
        return savedEntity;
    }
    
    // --- BATCH DELETION ---

    /**
     * Demonstrates deleteAllByIdInBatch() to remove multiple records efficiently.
     * Requires @Transactional since it's a modifying operation.
     */
    @Transactional
    public void deleteProductsInBatch(List<Integer> ids) {
        System.out.println("\n🗑️ Deleting batch of IDs: " + ids);
        // This executes a single, optimized DELETE query (e.g., DELETE WHERE ID IN (...))
        productDetailRepository.deleteAllByIdInBatch(ids);
        System.out.println("✅ Batch deletion completed (JPA cache is potentially out of sync).");
    }
    
}