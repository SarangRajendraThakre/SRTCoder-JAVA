package com.srt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srt.entity.AddressE;
import com.srt.entity.EmployeeE;
import com.srt.repository.EmployeeRepository;
import com.srt.request.AddressResquest;
import com.srt.request.EmployeeRequest;
import com.srt.response.EmployeeResponse;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    // Inject the MapStruct Mapper
    @Autowired 
    private EmployeeMapper employeeMapper;

    @Transactional
	public String createEmployee(EmployeeRequest employeeRequest) {
		
        // 1. Convert DTO to Entity using MapStruct
        EmployeeE employeeE = employeeMapper.toEntity(employeeRequest);
        
        // 2. SAVE
        EmployeeE savedEmployee = employeeRepository.save(employeeE);
		
		return "Employee created successfully with ID: " + savedEmployee.getEmployeeId();
	}

    @Transactional(readOnly = true)
    public EmployeeResponse getEmpById(Integer id) {
        
        Optional<EmployeeE> employeeOpt = employeeRepository.findById(id);
        
        EmployeeE employeeE = employeeOpt.orElseThrow(
            () -> new RuntimeException("Employee with ID " + id + " not found")
        );
        
        // 1. Convert Entity to Response DTO using MapStruct
        return employeeMapper.toResponse(employeeE);
    }

	@Transactional(readOnly = true)
	public List<EmployeeResponse> getEmpByDepartmentName(String departmentName) {
		
	    List<EmployeeE> employeeEs = employeeRepository.findByDname(departmentName);
	    
	    // 1. Convert List<Entity> to List<DTO> using MapStruct
	    return employeeMapper.toResponseList(employeeEs);
	}

    @Transactional(readOnly = true) // <-- FIX: Added transaction for read operation
	public List<EmployeeResponse> getAllEmployees() {
		
	    List<EmployeeE> employeeEs = employeeRepository.findAll();
	
	    return employeeMapper.toResponseList(employeeEs);
	}
	
    // FIX: Use MapStruct's list conversion method
	@Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployeesByCountryAndSalary(String country, double salary) {
        
        // Call the custom repository method
        List<EmployeeE> employeeEs = employeeRepository.findByAddressE_CountryAndSalary(country, salary);
        
        // MapStruct handles the list conversion automatically via toResponseList
        return employeeMapper.toResponseList(employeeEs);
    }
	
	@Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployeByHiredateAndNameStartwithS(LocalDate hDate, String name) {
        
        // 1. Call the new custom repository method
        List<EmployeeE> employeeEs = employeeRepository.findByHiredateGreaterThanEqualAndNameStartingWith(hDate, name);
        
        // 2. Convert List<Entity> to List<DTO> using MapStruct
        return employeeMapper.toResponseList(employeeEs);
    }
    
	@Transactional
    public String deleteEmployee(Integer id) {
        
        // Check if the employee exists before deleting
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with ID " + id + " not found for deletion.");
        }
        
        // 2. Perform the deletion
        employeeRepository.deleteById(id);
        
        // 3. Return confirmation
        return "Employee with ID " + id + " has been successfully deleted.";
    }
	
	@Transactional
    public EmployeeResponse updateEmployee(Integer id, EmployeeRequest employeeRequest) {
        
        // 1. Find the existing employee record, or throw an exception if not found
        EmployeeE existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found for update."));
        
        // 2. Map fields from the Request DTO to the existing Entity
        
        // Map top-level fields manually (or use MapStruct to update the object)
        existingEmployee.setName(employeeRequest.getName());
        existingEmployee.setSalary(employeeRequest.getSalary());
        existingEmployee.setDname(employeeRequest.getDname());
        existingEmployee.setLocation(employeeRequest.getLocation());
        existingEmployee.setHiredate(employeeRequest.getHiredate());
        
        // 3. Update the nested AddressE entity (if address data is provided in the request)
        AddressResquest addressRequest = employeeRequest.getAddressRequest();
        
        if (addressRequest != null && existingEmployee.getAddressE() != null) {
            
            // Assuming MapStruct has an update method, but performing manual update here:
            AddressE existingAddress = existingEmployee.getAddressE();

            existingAddress.setHouseNumber(addressRequest.getHouseNumber());
            existingAddress.setLocality(addressRequest.getLocality());
            existingAddress.setPincode(addressRequest.getPincode());
            existingAddress.setState(addressRequest.getState());
            existingAddress.setCountry(addressRequest.getCountry());
            
            // Note: Since the address is eagerly loaded and part of the relationship,
            // updating existingAddress will automatically be persisted when the parent is saved.
        }
        
        // 4. Save the updated Entity (Hibernate executes the UPDATE statements)
        EmployeeE updatedEmployee = employeeRepository.save(existingEmployee);

        // 5. Convert the updated Entity to Response DTO using MapStruct
        return employeeMapper.toResponse(updatedEmployee);
    }
	
}