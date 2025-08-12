package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiProviders {
    @Bean
     private RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
