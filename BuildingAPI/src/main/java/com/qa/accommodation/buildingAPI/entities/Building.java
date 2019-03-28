package com.qa.accommodation.buildingAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Building {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String buildingName;
	private String buildingLocation;
	private String ownerName;
	private String ownerNumber;
	private String ownerEmail;
	
	public Building() {
		
	}

	public Building(String buildingName, String buildingLocation, String ownerName, String ownerNumber,
			String ownerEmail) {
		super();
		this.buildingName = buildingName;
		this.buildingLocation = buildingLocation;
		this.ownerName = ownerName;
		this.ownerNumber = ownerNumber;
		this.ownerEmail = ownerEmail;
	}
	
	public long getId() {
		return id;
	}
	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getBuildingLocation() {
		return buildingLocation;
	}

	public void setBuildingLocation(String buildingLocation) {
		this.buildingLocation = buildingLocation;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	
	public boolean matches(Building building) {
		return (this.getBuildingName().contentEquals(building.getBuildingName()) || building.getBuildingName().contentEquals("N/A")) 
				&& (this.getBuildingLocation().contentEquals(building.getBuildingLocation()) || building.getBuildingLocation().contentEquals("N/A"))
				&& (this.getOwnerName().contentEquals(building.getOwnerName()) || building.getOwnerName().contentEquals("N/A"));
	}
	
}
