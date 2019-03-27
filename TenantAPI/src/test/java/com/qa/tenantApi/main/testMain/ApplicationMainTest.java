package com.qa.tenantApi.main.testMain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.tenantApi.main.TenantApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationMainTest {
	@Test
	public void mainTest() {
		String arg[] = {""};
		assertThat(TenantApiApplication.main(arg)).isEqualTo("Program ran successfully");
	}
}
