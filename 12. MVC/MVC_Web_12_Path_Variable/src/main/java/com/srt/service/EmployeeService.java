package com.srt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // Import for stream mapping

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srt.entity.AddressE;
import com.srt.entity.EmployeeE;
import com.srt.repository.EmployeeRepository;
import com.srt.request.AddressResquest;
import com.srt.request.EmployeeRequest;
import com.srt.response.AddressResponse; 
import com.srt.response.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    // NOTE: Removed unnecessary AddressRepository injection and constructor.

    @Transactional
	public String createEmployee(EmployeeRequest employeeRequest) {
		
        // ... (createEmployee method logic is correct) ...
        AddressResquest addressRequest = employeeRequest.getAddressRequest(); 
        AddressE addressE = new AddressE();
        addressE.setHouseNumber(addressRequest.getHouseNumber());
        addressE.setLocality(addressRequest.getLocality());
        addressE.setPincode(addressRequest.getPincode());
        addressE.setState(addressRequest.getState());
        addressE.setCountry(addressRequest.getCountry());
        
        EmployeeE employeeE = new EmployeeE();
        employeeE.setName(employeeRequest.getName());
        employeeE.setSalary(employeeRequest.getSalary());
        employeeE.setDname(employeeRequest.getDname());
        employeeE.setLocation(employeeRequest.getLocation());
        employeeE.setHiredate(employeeRequest.getHiredate());
        
        employeeE.setAddressE(addressE);
        
        EmployeeE savedEmployee = employeeRepository.save(employeeE);
		
		return "Employee created successfully with ID: " + savedEmployee.getEmployeeId();
	}

    @Transactional(readOnly = true)
    public EmployeeResponse getEmpById(Integer id) {
        
        Optional<EmployeeE> employeeOpt = employeeRepository.findById(id);
        
        EmployeeE employeeE = employeeOpt.orElseThrow(
            () -> new RuntimeException("Employee with ID " + id + " not found")
        );
        
        // 1. MAP AddressE Entity to AddressResponse DTO
        AddressE addressE = employeeE.getAddressE();
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setHouseNumber(addressE.getHouseNumber());
        addressResponse.setLocality(addressE.getLocality());
        addressResponse.setPincode(addressE.getPincode());
        addressResponse.setState(addressE.getState());
        addressResponse.setCountry(addressE.getCountry());
        
        // 2. MAP EmployeeE Entity to EmployeeResponse DTO
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(employeeE.getEmployeeId());
        response.setName(employeeE.getName());
        response.setSalary(employeeE.getSalary());
        response.setDname(employeeE.getDname());
        response.setLocation(employeeE.getLocation());
        response.setHiredate(employeeE.getHiredate());
        
        // 3. SET RELATIONSHIP
        response.setAddressResponse(addressResponse);
        
        return response;
    }

    // CORRECTED METHOD: Must map List<Entity> to List<DTO>
	@Transactional(readOnly = true)
	public List<EmployeeResponse> getEmpByDepartmentName(String departmentName) {
		
	    List<EmployeeE> employeeEs = employeeRepository.findByDname(departmentName);
	    
	    // Use stream to map each EmployeeE entity to an EmployeeResponse DTO
	    return employeeEs.stream()
	        .map(this::mapEmployeeEntityToResponse) // Call a helper method for mapping
	        .collect(Collectors.toList());
	}
	
	// Helper method to map a single EmployeeE to EmployeeResponse
	private EmployeeResponse mapEmployeeEntityToResponse(EmployeeE employeeE) {
	    // This uses the same mapping logic as getEmpById but is pulled out for clean list mapping
	    AddressE addressE = employeeE.getAddressE();
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setHouseNumber(addressE.getHouseNumber());
        addressResponse.setLocality(addressE.getLocality());
        addressResponse.setPincode(addressE.getPincode());
        addressResponse.setState(addressE.getState());
        addressResponse.setCountry(addressE.getCountry());
        
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(employeeE.getEmployeeId());
        response.setName(employeeE.getName());
        response.setSalary(employeeE.getSalary());
        response.setDname(employeeE.getDname());
        response.setLocation(employeeE.getLocation());
        response.setHiredate(employeeE.getHiredate());
        response.setAddressResponse(addressResponse);
        
        return response;
	}
}