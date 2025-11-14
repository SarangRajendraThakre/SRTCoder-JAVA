package com.srt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphqlClientConfig {

    // 1. Define the WebClient bean (Spring will manage this)
    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080/graphql") // Removed trailing space
                .build();
    }

    // 2. Define the HttpGraphQlClient, using the WebClient bean
    @Bean
    public HttpGraphQlClient client(WebClient webClient) {
        
        return HttpGraphQlClient.builder(webClient).build(); // Pass the configured WebClient
    }
    
}