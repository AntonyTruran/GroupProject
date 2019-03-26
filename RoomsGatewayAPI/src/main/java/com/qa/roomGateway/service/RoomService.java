package com.qa.roomGateway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.roomGateway.entity.Room;
import com.qa.roomGateway.repository.RoomRepo;

@Service
public class RoomService {

	public RoomService(RoomRepo repo) {
		this.repo = repo;
	}

	private RoomRepo repo;
	
	public String addRoom(Room room) {
		repo.save(room);
		return "{\"message\":\"room added\"}";
		}

	public List<Room> getAllRooms() {
		return this.repo.findAll();
	}

	public String getRooms(int request) {
		// TODO Auto-generated method stub
		return this.repo.findByRoomNumber(request).toString();
		}

	public String updateRoom(String roomReference) {
		// TODO Auto-generated method stub
		return null;
	}


}
