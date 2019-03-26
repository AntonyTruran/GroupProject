package com.qa.tenantApi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TenantApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(TenantApi1Application.class, args);
	}

}
