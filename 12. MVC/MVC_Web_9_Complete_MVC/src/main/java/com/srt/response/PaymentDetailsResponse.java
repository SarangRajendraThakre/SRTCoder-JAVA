package com.srt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDetailsResponse {

 private int 	payingAmount;
 private String	paymentStatus;
 private int 	bankTransactionId;
	
 
	
}
