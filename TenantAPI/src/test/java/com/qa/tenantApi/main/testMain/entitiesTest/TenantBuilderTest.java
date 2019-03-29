package com.qa.tenantApi.main.testMain.entitiesTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.tenantApi.main.Constants;
import com.qa.tenantApi.main.entities.TenantBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TenantBuilderTest {
	
	@Autowired
	private static TenantBuilder tenantBuilder;

	@Before
	public void getBuilder() {
		tenantBuilder = TenantBuilder.getTenantBuilder();
		assertThat(tenantBuilder).isNotNull();
	}

	@After
	public void resetBuilder() {
		tenantBuilder = TenantBuilder.getTenantBuilder();
		assertThat(tenantBuilder).isNotNull();
	}

	@Test
	public void blankBuild() {
		assertThat(tenantBuilder.tenantBuild().matches(Constants.getDefaultBuilderTenant())).isEqualTo(true);
	}

	@Test
	public void setterBuild() {
		assertThat(tenantBuilder.firstName(Constants.getTestFirstName()).lastName(Constants.getTestLastName())
				.contactNumber(Constants.getTestContactNumber()).contactEmail(Constants.getTestContactEmail())
				.qaEmail(Constants.getTestQaEmail()).roomReference(Constants.getTestRoomReference())
				.groupName(Constants.getTestGroupName()).startDate(Constants.getTestStartDate())
				.endDate(Constants.getTestEndDate()).notes(Constants.getTestNotes()).tenantBuild())
		.isEqualToComparingFieldByField(Constants.getConstructedTenant());
	}
}
