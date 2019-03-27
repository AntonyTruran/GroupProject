package com.qa.tenantApi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableDiscoveryClient
@SpringBootApplication
@EnableWebMvc
public class TenantApiApplication {

	public static String main(String[] args) {
		SpringApplication.run(TenantApiApplication.class, args);
		return "Program ran successfully";
	}

}
