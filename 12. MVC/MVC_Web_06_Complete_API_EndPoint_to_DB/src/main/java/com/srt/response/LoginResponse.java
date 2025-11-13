package com.srt.response;

import lombok.Data;

@Data
public class LoginResponse {

    // 💡 FIX 4: Removed the password field for security!
	private String emailId; 
    // You might add a 'success' status or an authentication token here.
	
}