package com.srt.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping; // <-- This is the one you need to fix
import org.mapstruct.factory.Mappers;

import com.srt.entities.AddressEntity;
import com.srt.entities.ItemsEntity;
import com.srt.entities.OrderInfoEntity;
import com.srt.entities.PaymentDetailsEntity;
import com.srt.request.AddressR;
import com.srt.request.ItemsR;
import com.srt.request.OrderInfoRequest;
import com.srt.request.PaymentDetailsR;
import com.srt.response.AddressResponse;
import com.srt.response.ItemsResponse;
import com.srt.response.OrderInfoResponse;
import com.srt.response.PaymentDetailsResponse;


//For your project to work, you need to treat MapStruct not just as a normal library, 
//but as a compiler extension. This is why you need to meticulously check both the <dependencies> 
//and the <build> (specifically the maven-compiler-plugin) sections of your pom.xml.
//If the processor fails to run, the application will fail to start because the generated code 
//won't exist


// componentModel="spring" allows the interface to be @Autowired as a Spring bean.
@Mapper(componentModel = "spring")
public interface OrderMapper {

    // --- MAPPING REQUEST DTO TO ENTITY (Input Mapping) ---

    // Maps the main request DTO to the main entity. 
    // MapStruct automatically uses the nested mappers (e.g., toItemEntity) for lists/objects.
    @Mapping(source = "itemsRList", target = "itemsEntities")
    @Mapping(source = "addressRList", target = "addressEntities")
    @Mapping(source = "paymentDetailsR", target = "paymentDetailsEntity")
    OrderInfoEntity toEntity(OrderInfoRequest request);

    // Nested Mappers (MapStruct uses these for lists)
    ItemsEntity toItemEntity(ItemsR itemR);
    AddressEntity toAddressEntity(AddressR addressR);
    PaymentDetailsEntity toPaymentEntity(PaymentDetailsR paymentR);


    // --- MAPPING ENTITY TO RESPONSE DTO (Output Mapping) ---

    // Maps the saved entity back to the response DTO.
    @Mapping(source = "itemsEntities", target = "itemsRList")
    @Mapping(source = "addressEntities", target = "addressRList")
    @Mapping(source = "paymentDetailsEntity", target = "paymentDetailsR")
    OrderInfoResponse toResponse(OrderInfoEntity entity);

    // Nested Mappers
    ItemsResponse toItemResponse(ItemsEntity itemEntity);
    AddressResponse toAddressResponse(AddressEntity addressEntity);
    PaymentDetailsResponse toPaymentResponse(PaymentDetailsEntity paymentEntity);
}