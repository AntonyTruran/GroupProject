package com.qa.landlordGateway.testMain;

import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;

public class Constants {
	private static final Landlord NULL_LANDLORD = new Landlord();
	private static final Landlord DEFAULT_BUILDER_LANDLORD = LandlordBuilder.getLandlord().landlordBuild();
	
	private static final String TEST_FIRST_NAME = "TestFirst";
	private static final String TEST_LAST_NAME = "TestLast";
	private static final String TEST_CONTACT_NUMBER = "07727715483";
	private static final String TEST_CONTACT_EMAIL = "TestEmail";
	private static final String NA_STRING = "N/A";
	private static final Landlord CONSTRUCTED_LANDLORD = new Landlord(
			TEST_FIRST_NAME,
			TEST_LAST_NAME,
			TEST_CONTACT_EMAIL,
			TEST_CONTACT_NUMBER);
	private static final String LANDLORD_CREATED = "Landlord Created";
	public static Landlord getNullLandlord() {
		return NULL_LANDLORD;
	}
	public static Landlord getDefaultBuilderLandlord() {
		return DEFAULT_BUILDER_LANDLORD;
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
	public static Landlord getConstructedLandlord() {
		return CONSTRUCTED_LANDLORD;
	}
	public static String getLandlordCreated() {
		return LANDLORD_CREATED;
	}
	public static String getNaString() {
		return NA_STRING;
	}
	
}
