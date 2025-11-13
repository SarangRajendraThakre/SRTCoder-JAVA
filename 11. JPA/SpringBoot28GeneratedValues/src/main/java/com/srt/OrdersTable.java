package com.srt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "APP_ORDER") // Using non-reserved table name for Oracle
@SequenceGenerator(
    name = "orderSeqGen", 
    sequenceName = "APP_ORDER_SEQ", // Matches the sequence created in Oracle SQL
    allocationSize = 1             
)
public class OrdersTable {
	
	@Id 
	@GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "orderSeqGen"
    ) 
	private Integer orderId; // Primary Key
	
	private String address;
}