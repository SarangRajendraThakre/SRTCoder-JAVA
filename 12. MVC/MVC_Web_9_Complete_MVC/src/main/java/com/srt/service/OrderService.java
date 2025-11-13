package com.srt.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srt.entities.AddressEntity;
import com.srt.entities.ItemsEntity;
import com.srt.entities.OrderInfoEntity;
import com.srt.entities.PaymentDetailsEntity;
import com.srt.repository.OrderRepository;
import com.srt.request.AddressR;
import com.srt.request.ItemsR;
import com.srt.request.OrderInfoRequest;
import com.srt.response.AddressResponse; // <-- NEW IMPORT
import com.srt.response.ItemsResponse;     // <-- NEW IMPORT
import com.srt.response.OrderInfoResponse; // <-- NEW IMPORT
import com.srt.response.PaymentDetailsResponse; // <-- NEW IMPORT

@Service
public class OrderService {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository; 
    // ... other repository autowiring ...

    // Signature changed to return OrderInfoResponse
    @Transactional
    public OrderInfoResponse createOrder(OrderInfoRequest orderInfoRequest) { 

        logger.info("Starting order creation for user: {}", orderInfoRequest.getFirstName());
        
        try {
            // --- 1. MAPPING REQUEST DTO TO ENTITY (Persist) ---
            
            // Payment
            PaymentDetailsEntity paymentDetailsEntity = new PaymentDetailsEntity();
            paymentDetailsEntity.setPayingAmount(orderInfoRequest.getPaymentDetailsR().getPayingAmount());
            paymentDetailsEntity.setPaymentStatus(orderInfoRequest.getPaymentDetailsR().getPaymentStatus());
            paymentDetailsEntity.setBankTransactionId(orderInfoRequest.getPaymentDetailsR().getBankTransactionId());

            // Items List
            List<ItemsEntity> itemsEntities = new ArrayList<>();
            for (ItemsR itemR : orderInfoRequest.getItemsRList()) {
                ItemsEntity itemsEntity = new ItemsEntity();
                itemsEntity.setProdName(itemR.getProdName());
                itemsEntity.setProdPrice(itemR.getProdPrice());
                itemsEntity.setProdQuantity(itemR.getProdQuantity());
                itemsEntity.setCharacteristics(itemR.getCharacteristics());
                itemsEntities.add(itemsEntity);
            }

            // Address List
            List<AddressEntity> addressEntities = new ArrayList<>();
            for (AddressR addressR : orderInfoRequest.getAddressRList()) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setHouseName(addressR.getHouseName());
                addressEntity.setLocality(addressR.getLocality());
                addressEntity.setPincode(addressR.getPincode());
                addressEntity.setCity(addressR.getCity());
                addressEntity.setState(addressR.getState());
                addressEntity.setCountry(addressR.getCountry());
                addressEntities.add(addressEntity);
            }

            // Order Info Entity
            OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
            orderInfoEntity.setFirstName(orderInfoRequest.getFirstName());
            orderInfoEntity.setTotalItems(orderInfoRequest.getTotalItems());
            orderInfoEntity.setTotalPrice(orderInfoRequest.getTotalPrice());
            orderInfoEntity.setPaymentDetailsEntity(paymentDetailsEntity);
            orderInfoEntity.setItemsEntities(itemsEntities);
            orderInfoEntity.setAddressEntities(addressEntities);

            logger.info("Attempting to save OrderInfoEntity...");
            OrderInfoEntity savedOrder = orderRepository.save(orderInfoEntity);
            logger.info("✅ Order successfully saved with ID: {}", savedOrder.getOrderId());
            
            
            // --- 2. MAPPING ENTITY BACK TO RESPONSE DTO (Return) ---
            
            // Map Payment Details
            PaymentDetailsResponse paymentResponse = new PaymentDetailsResponse();
            paymentResponse.setPayingAmount(savedOrder.getPaymentDetailsEntity().getPayingAmount());
            paymentResponse.setPaymentStatus(savedOrder.getPaymentDetailsEntity().getPaymentStatus());
            paymentResponse.setBankTransactionId(savedOrder.getPaymentDetailsEntity().getBankTransactionId());

            // Map Items List
            List<ItemsResponse> itemResponses = new ArrayList<>();
            for (ItemsEntity itemEntity : savedOrder.getItemsEntities()) {
                ItemsResponse itemResponse = new ItemsResponse();
                itemResponse.setProdName(itemEntity.getProdName());
                itemResponse.setProdPrice(itemEntity.getProdPrice());
                itemResponse.setProdQuantity(itemEntity.getProdQuantity());
                itemResponse.setCharacteristics(itemEntity.getCharacteristics());
                itemResponses.add(itemResponse);
            }

            // Map Address List
            List<AddressResponse> addressResponses = new ArrayList<>();
            for (AddressEntity addressEntity : savedOrder.getAddressEntities()) {
                AddressResponse addressResponse = new AddressResponse();
                addressResponse.setHouseName(addressEntity.getHouseName());
                addressResponse.setLocality(addressEntity.getLocality());
                addressResponse.setPincode(addressEntity.getPincode());
                addressResponse.setCity(addressEntity.getCity());
                addressResponse.setState(addressEntity.getState());
                addressResponse.setCountry(addressEntity.getCountry());
                addressResponses.add(addressResponse);
            }

            // Map final Order Response
            OrderInfoResponse finalResponse = new OrderInfoResponse();
            finalResponse.setFirstName(savedOrder.getFirstName());
            finalResponse.setTotalItems(savedOrder.getTotalItems());
            finalResponse.setTotalPrice(savedOrder.getTotalPrice());
            finalResponse.setPaymentDetailsR(paymentResponse);
            finalResponse.setItemsRList(itemResponses);
            finalResponse.setAddressRList(addressResponses);
            
            return finalResponse;
            
        } catch (Exception e) {
            logger.error("❌ FATAL ERROR: Order creation failed and transaction will be rolled back.", e);
            throw new RuntimeException("Order creation failed due to: " + e.getMessage(), e); 
        }
    }
}