package com.qa.roomGateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.qa.roomGateway.entity.Room;
import com.qa.roomGateway.service.RoomService;

@RestController
public class GatewayController {

	public GatewayController(EurekaClient client, RoomService service, RestTemplateBuilder rtb) {
		super();
		this.client = client;
		this.service = service;
		this.rtb = rtb;
	}

	@Autowired
	private EurekaClient client;
	
	private RoomService service;
	
	@Autowired
	private RestTemplateBuilder rtb;
	
	@PostMapping("/createRoom")
	public String addRoom(@RequestBody Room room) {
		return service.addRoom(room);
	}
	
	@GetMapping("/getAllRooms")
	public List<Room> getAllRooms() {
		return this.service.getAllRooms();
	}
	
	@GetMapping("/getSpecificRooms/{searchBy}")
	public String getSpecificRooms(@PathVariable("searchBy")int request) {
		return service.getRooms(request);	
	}
	//@PathVariable ("parameter")String parameter, 
	@PutMapping("/updateRoom/{roomReference}")
	public String updateRoom(@PathVariable("roomReference")String roomReference) {
		return service.updateRoom(roomReference);
	}
	//send to microservices
	
	//get building ref
	
	//create building?
	
	//get tennants
	
	//add tenants
	
	//update tenants
	
	//delete tenants
}
