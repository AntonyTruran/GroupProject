package com.qa.roomGateway.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {


	public Room() {
	}

	public Room(int roomId, String building, Integer aptNumber, Integer roomNumber, List<Room> events,
			String currentState, String landlord) {
		super();
		this.roomId = roomId;
		this.building = building;
		this.aptNumber = aptNumber;
		this.roomNumber = roomNumber;
		this.events = events;
		this.currentState = currentState;
		this.landlord = landlord;
	}
	
	@Id
	@GeneratedValue
	private int roomId;
	@Column
	private String building;
	@Column
	private Integer aptNumber;
	@Column
	private Integer roomNumber;
	@Column
	private List<Room> events;
	@Column
	private String currentState;
	@Column
	private String landlord;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public Integer getAptNumber() {
		return aptNumber;
	}
	public void setAptNumber(Integer aptNumber) {
		this.aptNumber = aptNumber;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<Room> getEvents() {
		return events;
	}
	public void setEvents(List<Room> events) {
		this.events = events;
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


}
