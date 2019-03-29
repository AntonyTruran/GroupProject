package com.qa.tenantApi.main.testMain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.tenantApi.main.Constants;
import com.qa.tenantApi.main.TenantApiApplication;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationMainTest {
	@Autowired
	private TenantApiApplication app;
	
	@Test
	public void appRuns() {
		app = new TenantApiApplication();
		String[] args = new String[] {Constants.getHelloWorld()};
		app.main(args);
		assertThat(app).isNotNull();
	}
	}
