package com.srt.config;

import org.springdoc.core.properties.SwaggerUiConfigProperties.Csrf;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	public SecurityFilterChain filerChain(HttpSecurity http) throws Exception
	{
		http
		   .csrf(csrf-> csrf.disable() )
		   .authorizeHttpRequests(auth -> auth
				   .requestMatchers("/**").permitAll()
				   .anyRequest().permitAll()
				   );
		   
		
		return http.build();
	}

}
