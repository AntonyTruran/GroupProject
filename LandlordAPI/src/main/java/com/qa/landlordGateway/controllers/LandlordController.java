package com.qa.landlordGateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;
import com.qa.landlordGateway.service.LandlordService;

@RestController
@CrossOrigin
public class LandlordController {

	private LandlordService landlordService;
	private LandlordBuilder landlordBuilder;
	
	public LandlordController(LandlordService landlordService, LandlordBuilder landlordBuilder) {
		this.landlordService = landlordService;
		this.landlordBuilder = landlordBuilder;
	}
	
	@PostMapping("/createLandlord")
	public String createLandlord(@RequestBody Landlord landlord) {
		this.landlordService.createLandlord(landlord);
		return "Landlord Created";
	}
	@GetMapping("/getAllLandlords")
	public List<Landlord> getLandlords(){
		return this.landlordService.getLandlords();
	}
	@GetMapping("/landlordSearch")
	public List<Landlord> landlordSearch(String firstName, String lastName){
		return this.landlordService.landlordSearh(landlordBuilder.firstName(firstName).lastName(lastName).landlordBuild());
	}
	@Autowired
	RestTemplateBuilder rtb;
}

