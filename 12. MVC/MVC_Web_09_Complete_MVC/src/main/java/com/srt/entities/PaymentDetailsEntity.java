package com.srt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PaymentDetailsEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payId_seq")
	@SequenceGenerator(name = "payId_seq", sequenceName = "payId_seq", allocationSize = 1)
	private Integer paymentId;
	
	private int payingAmount;
	private String paymentStatus;
	private int bankTransactionId;

}
