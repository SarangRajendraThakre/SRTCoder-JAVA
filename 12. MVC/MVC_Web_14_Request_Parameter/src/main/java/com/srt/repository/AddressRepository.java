package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.entity.AddressE;

public interface AddressRepository extends JpaRepository<AddressE, Integer> {

}
