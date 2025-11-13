package com.srt.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderInfoRequest {

	private String firstName;
	private int  totalItems;
	private double totalPrice;
	
	@Autowired
	private CartItemsR cartItemsR;
	
	
	@Autowired
	private List<AddressR> addressRList;
	
	@Autowired
	private PaymentDetailsR paymentDetailsR;
	
	
	
}












