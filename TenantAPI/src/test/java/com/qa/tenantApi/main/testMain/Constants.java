package com.qa.tenantApi.main.testMain;

import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.entities.TenantBuilder;

public class Constants {

	private final static Tenant NULL_TENANT = new Tenant();
	private final static Tenant DEFAULT_BUILDER_TENANT = TenantBuilder.getTenantBuilder().tenantBuild();

	private final static String TEST_FIRST_NAME = "TestFirst";
	private final static String TEST_LAST_NAME = "TestLast";
	private final static String TEST_CONTACT_NUMBER = "TestNumber";
	private final static String TEST_CONTACT_EMAIL = "TestEmail";
	private final static String TEST_QA_EMAIL = "TestQaEmail";
	private final static String TEST_ROOM_REFERENCE = "TestRoomReference";
	private final static String TEST_GROUP_NAME = "TestGroupName";
	private final static String TEST_START_DATE = "TestStartDate";
	private final static String TEST_END_DATE = "TestEndDate";
	private final static String TEST_NOTES = "TestNotes";
	private final static String NA_STRING = "N/A";

	private final static Tenant CONSTRUCTED_TENANT = new Tenant(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_CONTACT_NUMBER,
			TEST_CONTACT_EMAIL, TEST_QA_EMAIL, TEST_ROOM_REFERENCE, TEST_GROUP_NAME, TEST_START_DATE, TEST_END_DATE,
			TEST_NOTES);

	private final static String TENANT_CREATED = "New Tenant Created";

	public static String getTenantCreated() {
		return TENANT_CREATED;
	}

	public static String getNaString() {
		return NA_STRING;
	}

	public static Tenant getNullTenant() {
		return NULL_TENANT;
	}

	public static Tenant getDefaultBuilderTenant() {
		return DEFAULT_BUILDER_TENANT;
	}

	public static String getTestFirstName() {
		return TEST_FIRST_NAME;
	}

	public static String getTestLastName() {
		return TEST_LAST_NAME;
	}

	public static String getTestContactNumber() {
		return TEST_CONTACT_NUMBER;
	}

	public static String getTestContactEmail() {
		return TEST_CONTACT_EMAIL;
	}

	public static String getTestQaEmail() {
		return TEST_QA_EMAIL;
	}

	public static String getTestRoomReference() {
		return TEST_ROOM_REFERENCE;
	}

	public static String getTestGroupName() {
		return TEST_GROUP_NAME;
	}

	public static String getTestStartDate() {
		return TEST_START_DATE;
	}

	public static String getTestEndDate() {
		return TEST_END_DATE;
	}

	public static String getTestNotes() {
		return TEST_NOTES;
	}

	public static Tenant getConstructedTenant() {
		return CONSTRUCTED_TENANT;
	}

}
