package com.qa.roomGateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.roomGateway.entity.Room;


public class GatewayConstants {
	private static final String ROOM_ID = "TestFirst";
	private static final String BUILDING = "numberOne";
	private static final Integer ROOM_NUMBER = 1301;
	private static final int OCCUPANTS = 5;
	private static final String CURRENT_STATE = "TestQaEmail";
	private static final String LANDLORD = "TestRoomReference";
	private static final String NA_STRING = "N/A";
//	private static final ResponseEntity<List<Room>> MOCK_DELETE_RESPONSE = ResponseEntity<List<Room>>("[{\"roomId\": 2,\"building\": \"heart\",\"roomNumber\": 1301,\"occupants\": 2,\"currentState\": \"cleaned\",\"landlord\": \"Jason Joans\"}]" HttpStatus.OK);
	private static final String DELETE_BUILDING = "numberOne";
	private static final Integer DELETE_ROOM_NUM = 1301;
	private static final Room CONSTRUCTED_ROOM = new Room(BUILDING, ROOM_NUMBER, OCCUPANTS, null, CURRENT_STATE, LANDLORD);
	private static final Room NULL_ROOM = new Room();
	private static final String UPDATE_URL = "/updateRoom/{roomReference}";
	private static final String DELETION_URL = "/removeRoom";
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

//	public static ResponseEntity<List<Room>> getMockDeleteResponse() {
//		return MOCK_DELETE_RESPONSE;
//	}

	public static String getDeleteBuilding() {
		return DELETE_BUILDING;
	}

	public static Integer getDeleteRoomNum() {
		return DELETE_ROOM_NUM;
	}

	public static Room getNullRoom() {
		return NULL_ROOM;
	}

	public static String getUpdateUrl() {
		return UPDATE_URL;
	}

	public static String getDeletionUrl() {
		return DELETION_URL;
	}

}
