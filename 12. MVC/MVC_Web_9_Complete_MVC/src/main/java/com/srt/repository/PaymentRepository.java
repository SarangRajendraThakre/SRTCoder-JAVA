package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.entities.PaymentDetailsEntity;

public interface PaymentRepository extends JpaRepository<PaymentDetailsEntity, Integer> {

}
