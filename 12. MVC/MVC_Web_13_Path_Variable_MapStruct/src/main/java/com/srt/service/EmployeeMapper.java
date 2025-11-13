package com.srt.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.srt.entity.AddressE;
import com.srt.entity.EmployeeE;
import com.srt.request.AddressResquest;
import com.srt.request.EmployeeRequest;
import com.srt.response.AddressResponse;
import com.srt.response.EmployeeResponse;


// componentModel="spring" makes the generated class injectable
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // --- MAPPING REQUEST DTO TO ENTITY (for createEmployee) ---
    
    // Map the nested Address DTO to the Address Entity
    AddressE toAddressEntity(AddressResquest dto);
    
    // Map the main Employee Request DTO to the Employee Entity
    // Explicitly map the nested DTO (addressRequest) to the Entity relationship (addressE)
    @Mapping(source = "addressRequest", target = "addressE")
    EmployeeE toEntity(EmployeeRequest dto);


    // --- MAPPING ENTITY TO RESPONSE DTO (for getEmpById and getEmpByDepartmentName) ---
    
    // Map the nested Address Entity to the Address Response DTO
    AddressResponse toAddressResponse(AddressE entity);
    
    // Map the main Employee Entity to the Employee Response DTO
    // Explicitly map the Entity relationship (addressE) to the nested DTO (addressResponse)
    @Mapping(source = "addressE", target = "addressResponse")
    EmployeeResponse toResponse(EmployeeE entity);

    // Map List<Entity> to List<DTO> (MapStruct handles the loop automatically)
    List<EmployeeResponse> toResponseList(List<EmployeeE> entityList);
}