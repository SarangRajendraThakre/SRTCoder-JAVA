package com.srt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // <-- Import HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 1. **CRITICAL FIX:** Explicitly permit POST requests to /createOrder
                .requestMatchers(HttpMethod.POST, "/createOrder").permitAll() 
                .requestMatchers("/get/cars","/get/orders", "/user/login", "/user/createUser").permitAll()
                .requestMatchers(
                    "/swagger-ui/**"
                ).permitAll()
                
                // 4. Any other request MUST be authenticated
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}