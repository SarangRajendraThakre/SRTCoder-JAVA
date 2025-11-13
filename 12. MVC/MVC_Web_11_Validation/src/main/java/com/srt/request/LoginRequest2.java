package com.srt.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest2 {

    // Ensures field is not null and contains at least one non-whitespace character.
    @NotBlank(message = "First name is mandatory.")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
	private String firstName;
    
    // Not mandatory, so no @NotBlank needed, but adding size limits for safety.
    @Size(max = 50, message = "Last name cannot exceed 50 characters.")
	private String lastName;
    
    // Assuming gender is a specific choice, maybe validate with @Pattern later, but @NotBlank for now.
    @NotBlank(message = "Gender is required.")
	private String gender;
    
    @NotBlank(message = "Email ID is mandatory.")
    @Email(message = "Email ID must be a valid email format.")
	private String emailId;
    
    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
	private String password;
    
    // Note: @Valid is usually applied in the controller to nested objects, not here.
}