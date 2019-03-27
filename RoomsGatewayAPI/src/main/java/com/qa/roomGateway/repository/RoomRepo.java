package com.qa.roomGateway.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.roomGateway.entity.Room;

import io.micrometer.core.lang.Nullable;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
	@Transactional
	public List<Room> findByRoomNumber(int roomNumber);

	@Transactional
	public List<Room> findByBuilding(String building);
	
	@Transactional
	public List<Room> getRoomsByLandlord(String request);
	
	@Transactional
	public List<Room> deleteRoomByBuildingAndRoomNumber(@Nullable String building, @Nullable Integer roomNumber);
	
	@Transactional
	public List<Room> findByRoomNumberAndBuildingAndLandlord(@Nullable int roomNumber, String building, String landlord);
}
