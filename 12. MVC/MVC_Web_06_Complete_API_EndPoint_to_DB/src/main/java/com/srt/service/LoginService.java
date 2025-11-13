package com.srt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srt.entity.LoginEntity;
import com.srt.repository.LoginRepository;
import com.srt.request.UserLoginRequest;
import com.srt.response.LoginResponse;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	
	public LoginResponse login(UserLoginRequest userLoginRequest) {
        
        String email = userLoginRequest.getEmailId();
        String plainPassword = userLoginRequest.getPassword(); // Plain-text password received
        
        LoginEntity loginEntity = loginRepository.findByEmailId(email)
            .orElse(null);

        if (loginEntity != null && plainPassword.equals(loginEntity.getPassword())){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setEmailId(loginEntity.getEmailId());
            
            return loginResponse;

        } else {
            return null; 
        }
	}
}