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
	Constants constants;

	@Before
	public void getBuilder() {
		tenantBuilder = TenantBuilder.getTenantBuilder();
		assertThat(tenantBuilder).isNotNull();
		constants = new Constants();
	}

	@After
	public void resetBuilder() {
		tenantBuilder = TenantBuilder.getTenantBuilder();
		assertThat(tenantBuilder).isNotNull();
	}

	@Test
	public void blankBuild() {
		System.out.println(constants.getDefaultBuilderTenant().getFirstName());
		assertThat(TenantBuilder.tenantBuild().matches(constants.getDefaultBuilderTenant())).isEqualTo(true);
	}

	@Test
	public void setterBuild() {
		tenantBuilder.firstName(constants.getTestFirstName()).lastName(constants.getTestLastName())
				.contactNumber(constants.getTestContactNumber()).contactEmail(constants.getTestContactEmail())
				.qaEmail(constants.getTestQaEmail()).roomReference(constants.getTestRoomReference())
				.groupName(constants.getTestGroupName()).startDate(constants.getTestStartDate())
				.endDate(constants.getTestEndDate()).notes(constants.getTestNotes());
		assertThat(TenantBuilder.tenantBuild())
		.isEqualToComparingFieldByField(constants.getConstructedTenant());
	}
}
