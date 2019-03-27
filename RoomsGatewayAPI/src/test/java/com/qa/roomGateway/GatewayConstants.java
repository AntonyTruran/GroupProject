package com.qa.roomGateway;

import java.util.ArrayList;
import java.util.List;

import com.qa.roomGateway.entity.Room;


public class GatewayConstants {
	private final static String ROOM_ID = "TestFirst";
	private final static String BUILDING = "numberOne";
	private static final Integer ROOM_NUMBER = 1301;
	private final static int OCCUPANTS = 5;
	private final static String CURRENT_STATE = "TestQaEmail";
	private final static String LANDLORD = "TestRoomReference";
	private final static String NA_STRING = "N/A";

	private final static Room CONSTRUCTED_ROOM = new Room(BUILDING, ROOM_NUMBER, OCCUPANTS, CURRENT_STATE, LANDLORD);
	
	public static Integer getRoomNumber() {
		return ROOM_NUMBER;
	}

	public static String getRoomId() {
		return ROOM_ID;
	}

	public static String getBuilding() {
		return BUILDING;
	}

	public static int getOccupants() {
		return OCCUPANTS;
	}

	public static String getCurrentState() {
		return CURRENT_STATE;
	}

	public static String getLandlord() {
		return LANDLORD;
	}

	public static String getNaString() {
		return NA_STRING;
	}

	public static Room getConstructedRoom() {
		return CONSTRUCTED_ROOM;
	}

}
