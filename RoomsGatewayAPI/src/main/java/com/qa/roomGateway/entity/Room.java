package com.qa.roomGateway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {


	public Room(String building, int roomNumber, int occupants, String currentState, String landlord) {
		this.building = building;
		this.roomNumber = roomNumber;
		this.occupants = occupants;
		this.currentState = currentState;
		this.landlord = landlord;
	}

	public Room() {
	}
	
	@Id
	@GeneratedValue
	private int roomId;
	@Column
	private String building;
	@Column
	private Integer roomNumber;
	@Column(length = 1)
	private Integer occupants;
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

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getOccupants() {
		return occupants;
	}

	public void setOccupants(Integer occupants) {
		this.occupants = occupants;
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
