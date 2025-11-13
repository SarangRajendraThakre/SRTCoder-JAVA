package com.srt.entity;

import java.time.LocalDate;
import jakarta.persistence.CascadeType; // Import for cascade
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; // Import for foreign key
import jakarta.persistence.OneToOne; // Import for relationship
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class EmployeeE {

	@Id
	@SequenceGenerator(sequenceName = "employee_seq", initialValue = 10, allocationSize = 1, name = "employee_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	private Integer employeeId;
	
	private String name;
	private double salary;
	private String dname;
	private String location;
	private LocalDate hiredate;
	
    // CORRECT JPA RELATIONSHIP: One Employee to One Address
    // CascadeType.ALL ensures address is saved/deleted with the employee
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // Creates the foreign key column in the EmployeeE table
    private AddressE addressE; // Changed name to AddressE for consistency
}