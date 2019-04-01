package com.qa.roomGateway.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Apartment {

	@Id
	private String _id;
	private String building;
	private boolean isOpen = true;
	private Integer apartmentNumber;
	private Set<Event> elements = new HashSet<>();
	private Integer title;
	private Set<Room> tracks;
	private String currentState;
	
	private String landlord;
	public Apartment() {
	}

	public Apartment( String building, Integer aptNumber, Integer title, Set<Room> tracks,
			String currentState, String landlord) {
		this.building = building;
		this.apartmentNumber = aptNumber;
		this.title = title;
		this.tracks = tracks;
		this.currentState = currentState;
		this.landlord = landlord;
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
		return title;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.title = roomNumber;
	}
	public Set<Room> getRooms() {
		return tracks;
	}
	public void setRooms(Set<Room> events) {
		this.tracks = events;
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Set<Event> getElements() {
		return elements;
	}

	public void setElements(Set<Event> elements) {
		this.elements = elements;
	}

}
