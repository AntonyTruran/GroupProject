package com.qa.tenantApi.main;

import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.entities.TenantBuilder;

public class Constants {
	
	private static final Tenant NULL_TENANT = new Tenant();
	private static Tenant DEFAULT_BUILDER_TENANT = TenantBuilder.getTenantBuilder().tenantBuild();

	private static final String TEST_FIRST_NAME = "TestFirst";
	private static final String TEST_LAST_NAME = "TestLast";
	private static final String TEST_CONTACT_NUMBER = "TestNumber";
	private static final String TEST_CONTACT_EMAIL = "TestEmail";
	private static final String TEST_QA_EMAIL = "TestQaEmail";
	private static final String TEST_ROOM_REFERENCE = "TestRoomReference";
	private static final String TEST_GROUP_NAME = "TestGroupName";
	private static final String TEST_START_DATE = "TestStartDate";
	private static final String TEST_END_DATE = "TestEndDate";
	private static final String TEST_NOTES = "TestNotes";
	private static final String NA_STRING = "N/A";
	private static final String CREATION_MESSAGE = "New tenant created";
	private static final String DELETION_MESSAGE = "Tenant deleted";
	private static final String ALL_DELETION_MESSAGE = "All tenants deleted";
	private static final String UPDATE_MESSSAGE = "Tenant updated";
	private static final String GROUP_UPDATE_MESSAGE = "Tenant group updated";
	private static final String TENANTS_DELETION_MESSAGE = "Tenant(s) deleted";
	private static final String GROUP_DELETION_MESSAGE = "Tenant group deleted";
	private static final String HELLO_WORLD = "Hello World";
	private static final String GROUP_NAME = "groupName";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "Name";
	private static final String ID = "id";
	private static final String CHARSET = "utf8";
	
	private static final String CREATE_URL = "/createTenant";
	private static final String GET_ALL_URL = "/getAllTenants";
	private static final String SEARCH_URL = "/tenantSearch";
	private static final String GROUP_SEARCH_URL = "/tenantGroupSearch/{groupName}";
	private static final String DELETE_ALL_URL="/deleteAllTenants";
	private static final String DELETE_GROUP_URL ="/deleteTenantGroup/{groupName}";
	private static final String DELETE_URL="/deleteTenant";
	private static final String UPDATE_URL="/updateTenant/{id}";
	private static final String UPDATE_GROUP_URL="/updateTenantGroup/{groupName}";
	

	public static void setDefaultBuilderTenant(Tenant tenant) {
		DEFAULT_BUILDER_TENANT = tenant;
	}
	
	public static String getTenantsDeletionMessage() {
		return TENANTS_DELETION_MESSAGE;
	}

	public static String getCreateUrl() {
		return CREATE_URL;
	}

	public static String getGetAllUrl() {
		return GET_ALL_URL;
	}

	public static String getSearchUrl() {
		return SEARCH_URL;
	}

	public static String getGroupSearchUrl() {
		return GROUP_SEARCH_URL;
	}

	public static String getDeleteAllUrl() {
		return DELETE_ALL_URL;
	}

	public static String getDeleteGroupUrl() {
		return DELETE_GROUP_URL;
	}

	public static String getDeleteUrl() {
		return DELETE_URL;
	}

	public static String getUpdateUrl() {
		return UPDATE_URL;
	}

	public static String getUpdateGroupUrl() {
		return UPDATE_GROUP_URL;
	}

	public static String getFirstName() {
		return FIRST_NAME;
	}
	
	public static String getLastName() {
		return LAST_NAME;
	}

	public static String getId() {
		return ID;
	}

	public static String getGroupName() {
		return GROUP_NAME;
	}

	public static String getCharset() {
		return CHARSET;
	}

	public static String getGroupDeletionMessage() {
		return GROUP_DELETION_MESSAGE;
	}

	public static String getCreationMessage() {
		return CREATION_MESSAGE;
	}

	public static String getDeletionMessage() {
		return DELETION_MESSAGE;
	}

	public static String getAllDeletionMessage() {
		return ALL_DELETION_MESSAGE;
	}

	public static String getUpdateMesssage() {
		return UPDATE_MESSSAGE;
	}

	public static String getGroupUpdateMessage() {
		return GROUP_UPDATE_MESSAGE;
	}

	private static final Tenant CONSTRUCTED_TENANT = new Tenant(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_CONTACT_NUMBER,
			TEST_CONTACT_EMAIL, TEST_QA_EMAIL, TEST_ROOM_REFERENCE, TEST_GROUP_NAME, TEST_START_DATE, TEST_END_DATE,
			TEST_NOTES);

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

	public static String getHelloWorld() {
		return HELLO_WORLD;
	}

}
