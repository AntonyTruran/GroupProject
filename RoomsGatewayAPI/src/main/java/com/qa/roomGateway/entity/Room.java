package com.qa.roomGateway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

	public Room() {
		}
	public Room(String building, int roomNumber, int occupents, String currentState,String landlord) {
		this.building = building;
		this.roomNumber = roomNumber;
		this.occupents = occupents;
		this.currentState = currentState;
		this.landlord = landlord;
	}
	
	@Id
	@GeneratedValue
	private int roomId;
	@Column
	private String building;
	@Column
	private int roomNumber;
	@Column(length = 1)
	private int occupents;
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
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getOccupents() {
		return occupents;
	}
	public void setOccupents(int occupents) {
		this.occupents = occupents;
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
