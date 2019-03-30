package com.qa.roomGateway.entity;

import java.util.Set;

import org.bson.types.ObjectId;
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
		this._id= ObjectId.get().toString();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
