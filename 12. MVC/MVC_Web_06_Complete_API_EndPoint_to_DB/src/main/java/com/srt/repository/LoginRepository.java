package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srt.entity.LoginEntity;
import java.util.Optional; // Important for safe retrieval

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    Optional<LoginEntity> findByEmailId(String emailId); 
    
}