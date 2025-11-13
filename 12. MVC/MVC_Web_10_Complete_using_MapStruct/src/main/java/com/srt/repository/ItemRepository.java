package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srt.entities.ItemsEntity;

public interface ItemRepository extends JpaRepository<ItemsEntity,Integer > {

}
