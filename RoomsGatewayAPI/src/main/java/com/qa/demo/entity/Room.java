package com.qa.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

	public Room() {
		}
	
	public Room(String building, String roomNumber, int occupents, String currentState) {
		this.building = building;
		this.roomNumber = roomNumber;
		this.occupents = occupents;
		this.currentState = currentState;
	}
	
	@Id
	@GeneratedValue
	private long roomId;
	private String building;
	private String roomNumber;
	@Column(length = 1)
	private int occupents;
	private String currentState;
	
	
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
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
}
