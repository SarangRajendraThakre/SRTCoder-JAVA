package com.srt.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeResponse {

    // Include the generated ID for the response
    private Integer employeeId; 
    
	private String name;
	private double salary;
	private String dname;
	private String location;
	private LocalDate hiredate;
	
    // REMOVED @Autowired: Use nested DTO directly
	private AddressResponse addressResponse; 
}