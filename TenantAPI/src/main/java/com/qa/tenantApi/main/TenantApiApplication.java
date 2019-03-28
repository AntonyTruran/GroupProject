package com.qa.tenantApi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TenantApiApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(TenantApiApplication.class, args);
	}

}
