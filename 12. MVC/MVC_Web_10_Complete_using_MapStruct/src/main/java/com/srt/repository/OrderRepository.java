package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.entities.OrderInfoEntity;

public interface OrderRepository extends JpaRepository<OrderInfoEntity, Integer> {

}
