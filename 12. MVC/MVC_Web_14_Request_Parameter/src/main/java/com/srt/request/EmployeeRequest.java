package com.srt.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeRequest {

	private String name;
	private double salary;
	private String dname;
	private String location;
	private LocalDate hiredate;
	
    // The nested object uses the specific Request DTO type
	private AddressResquest addressRequest; // Corrected variable name
}