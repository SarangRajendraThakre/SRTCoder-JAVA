package com.srt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srt.dto.UserDetailDTO;
import com.srt.entity.UserEntity;
import com.srt.repository.UserDetailRepository;

@Service
public class UserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public String createUser(UserDetailDTO userDetailDTO) {

        // ✅ Check by unique email ID
        if (userDetailRepository.findByEmailId(userDetailDTO.getEmailId()).isPresent()) {
            return "User with this email already exists!";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmailId(userDetailDTO.getEmailId());
        userEntity.setFirstName(userDetailDTO.getFirstName());
        userEntity.setLastName(userDetailDTO.getLastName());
        userEntity.setGender(userDetailDTO.getGender());
        userEntity.setMarried(userDetailDTO.getMarried());
        userEntity.setSalary(userDetailDTO.getSalary());

        // ✅ ID is auto-generated (you don’t need to set it)
        userDetailRepository.save(userEntity);

        return "User created successfully with ID: " + userEntity.getId();
    }
}
