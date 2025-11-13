package com.srt.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// Removed @Entity as this is a DTO/Request object, not a JPA entity
public class OrderInfoRequest {

	private String firstName;
	private int totalItems;
	private double totalPrice;

    // Removed @Autowired
	private List<ItemsR> itemsRList;

    // Removed @Autowired
	private List<AddressR> addressRList;

    // Removed @Autowired
	private PaymentDetailsR paymentDetailsR;

}