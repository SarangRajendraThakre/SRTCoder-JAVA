package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.entities.AddressEntity;
import com.srt.entities.OrderInfoEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
