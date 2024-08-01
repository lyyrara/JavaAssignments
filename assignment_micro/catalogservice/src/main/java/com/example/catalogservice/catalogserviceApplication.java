package com.example.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class catalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(catalogserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		System.out.println("insdie restTemplate Bean()");
		return new RestTemplate();
	}
}
