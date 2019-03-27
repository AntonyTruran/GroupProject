package com.qa.tenantApi.main.testMain.entitiesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.testMain.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TenantTest {

	@Test
	public void superConstructorTest() {
		Tenant tenant = new Tenant();
		assertThat(tenant).isNotNull();
	}

	@Test
	public void fullConstructorTest() {
		Tenant tenant = new Tenant(Constants.getNaString(), Constants.getNaString(), Constants.getNaString(),
				Constants.getNaString(), Constants.getNaString(), Constants.getNaString(), Constants.getNaString(),
				Constants.getNaString(), Constants.getNaString(), Constants.getNaString());
		assertThat(tenant.matches(Constants.getDefaultBuilderTenant()));
	}

	@Test
	public void getterTest() {
		assertNull(Constants.getNullTenant().getFirstName());
		assertNull(Constants.getNullTenant().getLastName());
		assertNull(Constants.getNullTenant().getContactNumber());
		assertNull(Constants.getNullTenant().getContactEmail());
		assertNull(Constants.getNullTenant().getQaEmail());
		assertNull(Constants.getNullTenant().getRoomReference());
		assertNull(Constants.getNullTenant().getGroupName());
		assertNull(Constants.getNullTenant().getStartDate());
		assertNull(Constants.getNullTenant().getEndDate());
		assertNull(Constants.getNullTenant().getNotes());
		assertThat(Constants.getNullTenant().getId()).isEqualTo(0);
	}

	@Test
	public void setterTest() {
		Tenant testTenant = Constants.getNullTenant();
		testTenant.setFirstName(Constants.getNaString());
		testTenant.setLastName(Constants.getNaString());
		testTenant.setContactNumber(Constants.getNaString());
		testTenant.setContactEmail(Constants.getNaString());
		testTenant.setQaEmail(Constants.getNaString());
		testTenant.setRoomReference(Constants.getNaString());
		testTenant.setGroupName(Constants.getNaString());
		testTenant.setStartDate(Constants.getNaString());
		testTenant.setEndDate(Constants.getNaString());
		testTenant.setNotes(Constants.getNaString());
		assertThat(testTenant.matches(Constants.getConstructTenant()));
	}
}
