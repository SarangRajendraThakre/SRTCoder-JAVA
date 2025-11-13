package com.srt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Emp_dtl")
public class Employee {
	
	@Id
	@SequenceGenerator(name = "emp_id_seq" , sequenceName = "emp_id_seq" , initialValue = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE.AUTO , generator = "emp_id_seq")
	private Integer empId;
	
	private String empName;
	
	private String gender;
	
	// Defining Relationship
	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	
}
