package com.qa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.entity.Room;

public interface RoomRepo extends JpaRepository<Room, Long>{

}
