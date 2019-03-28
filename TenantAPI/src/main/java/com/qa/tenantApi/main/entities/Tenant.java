package com.qa.tenantApi.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tenant {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	private String lastName;
	private String contactNumber;
	private String contactEmail;
	private String QaEmail;
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
		this.QaEmail = qaEmail;
		this.roomReference = roomReference;
		this.groupName = groupName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.notes = notes;
	}

	@Column
	public long getId() {
		return id;
	}

	@Column
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	@Column
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Column
	public String getQaEmail() {
		return QaEmail;
	}

	public void setQaEmail(String qaEmail) {
		QaEmail = qaEmail;
	}

	@Column
	public String getRoomReference() {
		return roomReference;
	}

	public void setRoomReference(String roomReference) {
		this.roomReference = roomReference;
	}

	@Column
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean matches(Tenant tenant) {

		return ((this.getFirstName().contentEquals(tenant.getFirstName()) || tenant.getFirstName().contentEquals("N/A"))
				&& (this.getLastName().contentEquals(tenant.getLastName()) || tenant.getLastName().contentEquals("N/A"))
				&& (this.getGroupName().contentEquals(tenant.getGroupName())
						|| tenant.getGroupName().contentEquals("N/A")));
	}
}
