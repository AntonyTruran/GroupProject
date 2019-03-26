package com.qa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.qa.demo.entity.Room;
import com.qa.demo.service.RoomService;

@RestController
public class GatewayController {

	@Autowired
	private EurekaClient client;
	
	private RoomService service;
	
	@Autowired
	private RestTemplateBuilder rtb;
	
	@PostMapping("/newRoom")
	public String addRoom(@RequestBody Room room) {
		return service.addRoom(room);
	}
}
