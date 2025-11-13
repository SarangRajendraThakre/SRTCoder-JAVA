package com.srt.response;

import java.util.List;

// Import removed: import jakarta.persistence.Entity; 
// The following import should be removed if it was present, as DTOs shouldn't use it:
// import org.springframework.beans.factory.annotation.Autowired; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// REMOVED: @Entity 
public class OrderInfoResponse {

	private String firstName;
	private int totalItems;
	private double totalPrice;

	// Ensure @Autowired is removed if it was present, as DTOs don't need it.
	private List<ItemsResponse> itemsRList; 

	// Ensure @Autowired is removed if it was present, as DTOs don't need it.
	private List<AddressResponse> addressRList; 

	// Ensure @Autowired is removed if it was present, as DTOs don't need it.
	private PaymentDetailsResponse paymentDetailsR; 

}