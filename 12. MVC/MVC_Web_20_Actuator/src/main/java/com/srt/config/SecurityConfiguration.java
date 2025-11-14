package com.srt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
//In com.srt.config.SecurityConfiguration.java
//In com.srt.config.SecurityConfiguration.java
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	// In com.srt.config.SecurityConfiguration.java

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                "/v3/api-docs/**",
	                "/swagger-ui/**",
	                "/swagger-ui.html"
	            ).permitAll() // Allow documentation access

	            // ADD THIS LINE to allow unauthenticated POST requests to your endpoint:
	            .requestMatchers(HttpMethod.POST, "/add/product").permitAll()
	            
	            // Secure all other requests (recommended)
	            .anyRequest().authenticated()
	        );
	    return http.build();
	}
}