package com.qa.tenantApi.main.testMain.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.tenantApi.main.repository.TenantRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TenantRepoTest {

	@Autowired
	private TenantRepo tenantRepo;

	@Test
	public void initializationTest() {
		assertThat(tenantRepo).isNotNull();
	}

	@Test
	public void noDataTest() {
		assertThat(tenantRepo.count()).isEqualTo(0);
	}

}
