package com.qa.tenantApi.main.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.qa.tenantApi.main.Constants;

@Entity
public class Tenant {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	private String lastName;
	private String contactNumber;
	private String contactEmail;
	private String qaEmail;
	private String roomReference;
	private String groupName;
	private String startDate;
	private String endDate;
	private String notes;

	public Tenant() {
		
	}
	
	public Tenant(String firstName, String lastName, String contactNumber, String contactEmail, String qaEmail,
			String roomReference, String groupName, String startDate, String endDate, String notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
		this.qaEmail = qaEmail;
		this.roomReference = roomReference;
		this.groupName = groupName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getQaEmail() {
		return qaEmail;
	}

	public void setQaEmail(String qaEmail) {
		this.qaEmail = qaEmail;
	}

	public String getRoomReference() {
		return roomReference;
	}

	public void setRoomReference(String roomReference) {
		this.roomReference = roomReference;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean matches(Tenant tenant) {

		Boolean firstCheck = this.getFirstName().contentEquals(tenant.getFirstName());
		Boolean firstNull = tenant.getFirstName().contentEquals(Constants.getNaString());
		Boolean lastCheck = this.getLastName().contentEquals(tenant.getLastName());
		Boolean lastNull = tenant.getLastName().contentEquals(Constants.getNaString());
		Boolean groupCheck = this.getGroupName().contentEquals(tenant.getGroupName());
	    Boolean groupNull = tenant.getGroupName().contentEquals(Constants.getNaString());
		
		firstCheck = firstCheck||firstNull;
		lastCheck = lastCheck||lastNull;
		groupCheck = groupCheck||groupNull;
		return (firstCheck && lastCheck && groupCheck);
	}
}
