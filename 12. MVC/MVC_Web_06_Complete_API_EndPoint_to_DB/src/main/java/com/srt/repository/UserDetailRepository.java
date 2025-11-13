package com.srt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srt.entity.UserEntity;

public interface UserDetailRepository extends JpaRepository<UserEntity, Integer> {
    
    // Custom query method
    Optional<UserEntity> findByEmailId(String emailId);
}
