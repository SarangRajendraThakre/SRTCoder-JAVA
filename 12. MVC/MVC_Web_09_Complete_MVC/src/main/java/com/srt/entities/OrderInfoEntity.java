package com.srt.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderInfoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
	private Integer orderId;

	private String firstName;
	private int totalItems;
	private double totalPrice;
	
    // Correct JPA relationships
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id") // Optional: to map the foreign key in the AddressEntity table
	private List<AddressEntity> addressEntities;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id") // Optional: to map the foreign key in the ItemsEntity table
	private List<ItemsEntity> itemsEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id") // Maps the foreign key column to PaymentDetailsEntity's PK
	private PaymentDetailsEntity paymentDetailsEntity;
	
}