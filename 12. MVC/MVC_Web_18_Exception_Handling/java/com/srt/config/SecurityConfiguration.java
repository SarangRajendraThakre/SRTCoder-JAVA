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

 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 http.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Allow public access to documentation
			    .requestMatchers(HttpMethod.POST, "/add/product").authenticated() // Require login for adding product
			    .anyRequest().authenticated() // All other requests must be authenticated
			);

     return http.build();
 }
}