package com.qa.roomGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.qa.roomGateway.repository.ApartmentRepo;

@EnableDiscoveryClient
@SpringBootApplication
public class RoomsGatewayApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(RoomsGatewayApiApplication.class, args);
	}
}
