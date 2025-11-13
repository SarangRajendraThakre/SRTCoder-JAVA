package com.srt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseOperation {

    private final SpringBoot28GeneratedValuesApplication springBoot28GeneratedValuesApplication;

	@Autowired
	EmployeeRepository employeeRepository;

    DatabaseOperation(SpringBoot28GeneratedValuesApplication springBoot28GeneratedValuesApplication) {
        this.springBoot28GeneratedValuesApplication = springBoot28GeneratedValuesApplication;
    }

	public void addEmployee() {
		Address address = new Address();
		address.setCity("Wardha");
		address.setCountry("India");
		address.setPincode(442001);

		Employee employee = new Employee();
		employee.setEmpName("SARANg");
		employee.setGender("Male");

		employee.setAddress(address);

		employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById() {
		
		    employeeRepository.deleteById(101);
		
	}
	
//	public void findByAddressJoinJPQL() {
//		
//	List<Employee> list   = employeeRepository.findByAddressCityJPQL("Wardha");
//	System.out.println(list);
//		
//	}
	
	public void findByAddressJoinDerived() {
		
	List<Employee> list   = employeeRepository.findByAddress_City("Wardha");
	System.out.println(list);
		
	}
	
	

}
