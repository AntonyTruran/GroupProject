package com.qa.accommodation.buildingAPI;

import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.entities.BuildingBuilder;

public class Constants {
	private static final String DELETE_SUCCESS = "Successfully Deleted";
	private static final String CREATE_SUCCESS = "Building has been successfully created";
	
	private final static Building NULL_BUILDING = new Building();
	private final static Building BUILDING_BUILDER = BuildingBuilder.getBuildingBuilder().buildingBuild();
	
	private final static String TEST_BUILDING_NAME = "Test Building";
	private final static String TEST_BUILDING_LOCATION = "20 Test Avenue, Test Street";
	private final static String TEST_OWNER_NAME = "Test Owner";
	private final static String TEST_OWNER_NUMBER = "07778889991";
	private final static String TEST_OWNER_EMAIL = "TestOwner@Tester.com";
	
	private final static Building CONSTRUCTED_BUILDING = new Building(TEST_BUILDING_NAME, TEST_BUILDING_LOCATION,
			TEST_OWNER_NAME, TEST_OWNER_NUMBER, TEST_OWNER_EMAIL);
	
	public static String getDeleteSuccess() {
		return DELETE_SUCCESS;
	}
	public static String getCreateSuccess() {
		return CREATE_SUCCESS;
	}
	
	public static Building getNullBuilding() {
		return NULL_BUILDING;
	}
	public static Building getBuildingBuilder() {
		return BUILDING_BUILDER;
	}
	
	
}
