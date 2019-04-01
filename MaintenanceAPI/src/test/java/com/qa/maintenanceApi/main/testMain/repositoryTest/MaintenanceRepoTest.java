package com.qa.maintenanceApi.main.testMain.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
<<<<<<< HEAD:TenantAPI/src/test/java/com/qa/tenantApi/main/testMain/repositoryTest/TenantRepoTest.java
=======
import com.qa.maintenanceApi.main.repositories.MaintenanceRepo;
>>>>>>> MaintenanceApiBranch:MaintenanceAPI/src/test/java/com/qa/maintenanceApi/main/testMain/repositoryTest/MaintenanceRepoTest.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MaintenanceRepoTest {

	@Autowired
	private MaintenanceRepo maintenanceRepo;

	@Test
	public void initializationTest() {;
<<<<<<< HEAD:TenantAPI/src/test/java/com/qa/tenantApi/main/testMain/repositoryTest/TenantRepoTest.java
		assertThat(this.tenantRepo).isNotNull();
=======
		assertThat(this.maintenanceRepo).isNotNull();
>>>>>>> MaintenanceApiBranch:MaintenanceAPI/src/test/java/com/qa/maintenanceApi/main/testMain/repositoryTest/MaintenanceRepoTest.java
	}

	@Test
	public void noDataTest() {
<<<<<<< HEAD:TenantAPI/src/test/java/com/qa/tenantApi/main/testMain/repositoryTest/TenantRepoTest.java
		assertThat(this.tenantRepo.count()).isEqualTo(0);
=======
		assertThat(this.maintenanceRepo.count()).isEqualTo(0);
>>>>>>> MaintenanceApiBranch:MaintenanceAPI/src/test/java/com/qa/maintenanceApi/main/testMain/repositoryTest/MaintenanceRepoTest.java
	}

}
