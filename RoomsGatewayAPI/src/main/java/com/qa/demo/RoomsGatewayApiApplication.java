package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RoomsGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomsGatewayApiApplication.class, args);
	}

}
