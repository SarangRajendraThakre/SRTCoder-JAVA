package com.srt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseOperations {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// --- DDL Method: CREATE ---
	public void createProductTable() {
		String ddlQuery = "CREATE TABLE PRODUCT ("
						+ "  PID NUMBER(2,0) PRIMARY KEY,"
						+ "  PNAME VARCHAR2(20),"
						+ "  PPRICE NUMBER(5)"
						+ ")";
		
		// Used for DDL (CREATE, DROP, ALTER)
		jdbcTemplate.execute(ddlQuery);
		System.out.println("PRODUCT table created successfully.");
	}

	// --- DML Method: INSERT (No placeholders) ---
	public void addProduct() {
		jdbcTemplate.update("INSERT INTO PRODUCT VALUES  (54, 'BOOKS', 110)");
	}

	// --- DML Method: INSERT (With placeholders) ---
	public void saveProduct() {
		String query = "INSERT INTO PRODUCT VALUES  (?,?,?)";
		// Using placeholders simplifies quoting and prevents SQL injection
		jdbcTemplate.update(query, 90, "pen", 10);
		System.out.println("Product saved.");
	}

	// --- DML Method: DELETE ---
	public void deleteProduct() {
		jdbcTemplate.update("DELETE FROM PRODUCT WHERE pid=1");
		System.out.println("Product deleted.");
	}

	// --- DML Method: SELECT ---
	public void loadAllProduct() {
		String query = "SELECT  PID, PNAME, PPRICE FROM PRODUCT";
        
        // Maps rows to ProductDetails objects
		java.util.List<ProductDetails> allProduct = jdbcTemplate.query(
            query, 
            new BeanPropertyRowMapper<>(ProductDetails.class)
        );

        System.out.println("\n--- All Products ---");
		allProduct.forEach(Product -> {
			System.out.println("ID: " + Product.getPid() + ", Name: " + Product.getPname() + ", Price: " + Product.getPprice());
		});
        System.out.println("--------------------\n");
	}
}