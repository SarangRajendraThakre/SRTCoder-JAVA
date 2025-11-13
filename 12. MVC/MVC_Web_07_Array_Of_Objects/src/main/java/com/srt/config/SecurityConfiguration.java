package com.srt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // -----------------------------------------------------------
    // 1. Define the Security Filter Chain (Authorization Rules)
    // -----------------------------------------------------------
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 💡 1a. Temporarily disable CSRF for development. 
            // This is required for POST/PUT/DELETE requests to work easily from Swagger/Postman.
            .csrf(csrf -> csrf.disable())
            
            // 💡 1b. Define authorization rules for HTTP requests
            .authorizeHttpRequests(auth -> auth
                
                // Allow public access to your /get/cars endpoint
                .requestMatchers("/get/cars").permitAll()
                
                // Allow public access to your login and create user endpoints
                .requestMatchers("/user/login", "/user/createUser").permitAll()
                
                // Allow public access to all Swagger UI documentation paths
                .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                
                // Any other request MUST be authenticated (logged in)
                .anyRequest().authenticated()
            );
            
        // You might add form login or HTTP Basic authentication here if needed, 
        // but the code above is enough to resolve the 403 error and permit your endpoints.
        
        return http.build();
    }

    // -----------------------------------------------------------
    // 2. Define the PasswordEncoder Bean (Required by LoginService)
    // -----------------------------------------------------------
    // This bean is necessary for the LoginService to securely hash and compare passwords.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
} 

