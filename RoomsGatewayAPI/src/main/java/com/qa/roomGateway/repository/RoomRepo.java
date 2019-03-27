package com.qa.roomGateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.roomGateway.entity.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
	public List<Room> findByRoomNumber(int roomNumber);

	public List<Room> findByBuilding(String building);

	public List<Room> getRoomsByLandlord(String request);

	public void deleteRoomByBuildingAndRoomNumber(String building, int roomNumber);
}
