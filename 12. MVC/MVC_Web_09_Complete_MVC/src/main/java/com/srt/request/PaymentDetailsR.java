package com.srt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDetailsR {

 private int 	payingAmount;
 private String	paymentStatus;
 private int 	bankTransactionId;
	
 
	
}
