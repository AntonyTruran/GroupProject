package com.qa.roomGateway.entity;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Room {
	@Id
	private String id;
	private String title;
	private Set<Event> elements;

	public Room() {
	}

	public Room(String roomName, Set<Event> elements) {
		this.title = roomName;
		this.elements = elements;
		this.id= ObjectId.get().toString();
	}

	public String get_id() {
		return id;
	}

	public void set_id(String _id) {
		this.id = _id;
	}

	public String getRoomName() {
		return title;
	}

	public void setRoomName(String roomName) {
		this.title = roomName;
	}

	public Set<Event> getEvents() {
		return elements;
	}

	public void setEvents(Set<Event> events) {
		this.elements = events;
	}

}
