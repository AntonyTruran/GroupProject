package com.qa.roomGateway.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//		currentDetails.setOccupants(updatedRoom.getOccupants());
		currentDetails.setLandlord(updatedRoom.getLandlord());
		repo.save(currentDetails);
		return "{\"message\":\"room updated\"}";
	}

	public ResponseEntity<List<Room>> deleteRoom(String building, Integer roomNumber) {
		List<Room> room = repo.deleteRoomByBuildingAndRoomNumber(building, roomNumber);
		return new ResponseEntity<List<Room>>(room, HttpStatus.OK);
	}
	
//	public String deleteRoomCustom(String building, int roomNumber) {
//		this.repo.deleteRoomByBuildingAndRoomNumber(building,roomNumber);
//		return "{\"message\":\"room updated\"}";
//	}

}
