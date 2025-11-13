package com.srt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // Keep this import, although MapStruct handles the core logic

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srt.entity.EmployeeE;
import com.srt.repository.EmployeeRepository;
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
	
}