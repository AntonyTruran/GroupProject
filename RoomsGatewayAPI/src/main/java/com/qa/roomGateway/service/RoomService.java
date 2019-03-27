package com.qa.roomGateway.service;

import java.util.ArrayList;
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

	public List<Room> getRoomsByNumber(int request) {
		return this.repo.findByRoomNumber(request);
	}

	public List<Room> getRoomsByBuilding(String request) {
		return this.repo.findByBuilding(request);
	}

	public List<Room> getRoomsByLandlord(String request) {
		return this.repo.getRoomsByLandlord(request);
	}

	public String updateRoom(String roomReference, Room updatedRoom) {
		Room currentDetails = this.repo.getOne(updatedRoom.getRoomId());
		currentDetails.setCurrentState(updatedRoom.getCurrentState());
		currentDetails.setOccupents(updatedRoom.getOccupents());
		repo.save(currentDetails);
		return "{\"message\":\"room updated\"}";
	}

	public String deleteRoom(String building, int roomNumber) {
		Room selectedRoom = null;
		int selectedId=0;
		List<Room> roomList = this.getRoomsByNumber(roomNumber);
		for (Room apartment : roomList) {
			if(apartment.getBuilding().equals(building)) {
				selectedRoom = apartment;
			}
		}
		selectedId=selectedRoom.getRoomId();
		this.repo.deleteById(selectedId);
		return "{\"message\":\"room updated\"}";
	}
	
	public String deleteRoomCustom(String building, int roomNumber) {
		this.repo.deleteRoomByBuildingAndRoomNumber(building,roomNumber);
		return "{\"message\":\"room updated\"}";
	}

}
