package com.qa.maintenanceApi.main;

public class Constants {

	private static String naString = "NA";
	private static final String CREATION_MESSAGE = "New entry added";
	private static final String DELETION_MESSAGE = "Entry(ies) deleted";
	private static final String ALL_DELETION_MESSAGE = "All entries deleted";
	private static final String UPDATE_MESSSAGE = "Entry updated";
	
	public static final String CREATE_URL = "/createMaintenance";
	public static final String GET_ALL_URL = "/getAllMaintenance";
	public static final String SEARCH_URL = "/maintenanceSearch";
	public static final String DELETE_ALL_URL="/deleteAllMaintenance";
	public static final String DELETE_URL="/deleteMaintenance";
	public static final String UPDATE_URL="/updateMaintenance/{id}";
	

	public static String getNaString() {
		return naString;
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
}
