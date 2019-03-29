package com.qa.roomGateway.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class Room {
	@Id
	private String _id;
	private String roomName;
	
	private Set<Event> events;
	
	public Room() {
	}
	
	public Room(String roomName, Set<Event> events) {
		this.roomName = roomName;
		this.events = events;
	}

	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
}
