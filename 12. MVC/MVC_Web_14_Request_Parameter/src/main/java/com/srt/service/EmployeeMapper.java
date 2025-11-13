package com.srt.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget; // <-- Import required for update methods

import com.srt.entity.AddressE;
import com.srt.entity.EmployeeE;
import com.srt.request.AddressResquest;
import com.srt.request.EmployeeRequest;
import com.srt.response.AddressResponse;
import com.srt.response.EmployeeResponse;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // --- MAPPING REQUEST DTO TO ENTITY (Creation) ---
    AddressE toAddressEntity(AddressResquest dto);
    
    @Mapping(source = "addressRequest", target = "addressE")
    EmployeeE toEntity(EmployeeRequest dto);


    // --- MAPPING ENTITY TO RESPONSE DTO (Retrieval) ---
    AddressResponse toAddressResponse(AddressE entity);
    
    @Mapping(source = "addressE", target = "addressResponse")
    EmployeeResponse toResponse(EmployeeE entity);

    List<EmployeeResponse> toResponseList(List<EmployeeE> entityList);


    // =======================================================
    // --- NEW: UPDATE MAPPING METHODS (for updateEmployee) ---
    // =======================================================
    
    // 1. Method to update an existing EmployeeE (target) using data from EmployeeRequest (source)
    @Mapping(target = "employeeId", ignore = true) // PK should never be updated
    @Mapping(target = "addressE", ignore = true)     // We update the nested address separately
    void updateEmployeeEntity(EmployeeRequest dto, @MappingTarget EmployeeE entity);

    // 2. Method to update an existing AddressE (target) using data from AddressResquest (source)
    @Mapping(target = "addressId", ignore = true) // PK should not be updated
    void updateAddressEntity(AddressResquest dto, @MappingTarget AddressE entity);
}










