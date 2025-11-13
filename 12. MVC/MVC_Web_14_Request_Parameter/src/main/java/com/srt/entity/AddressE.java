package com.srt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class AddressE {
	
	@Id
	@SequenceGenerator(sequenceName = "address_seq", initialValue = 10, allocationSize = 1, name = "address_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "address_seq" )
	private Integer addressId;
	private String		houseNumber;
	private String		locality;
	private int		   pincode;
	private String		state;
	private String		country;
}