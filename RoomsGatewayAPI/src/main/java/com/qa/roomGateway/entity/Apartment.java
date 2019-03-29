package com.qa.roomGateway.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Apartment {

	@Id
	private String _id;
	private String building;

	private Integer apartmentNumber;
	
	private Integer roomNumber;
	
	private Set<Room> rooms;
	
	private String currentState;
	
	private String landlord;
	public Apartment() {
	}

	public Apartment( String building, Integer aptNumber, Integer roomNumber, Set<Room> rooms,
			String currentState, String landlord) {
		this.building = building;
		this.apartmentNumber = aptNumber;
		this.roomNumber = roomNumber;
		this.rooms = rooms;
		this.currentState = currentState;
		this.landlord = landlord;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public Integer getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(Integer aptNumber) {
		this.apartmentNumber = aptNumber;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> events) {
		this.rooms = events;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getLandlord() {
		return landlord;
	}
	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}
	@Override
    public String toString() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
    	return jsonString;
    }

}
