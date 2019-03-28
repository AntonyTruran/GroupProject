package com.qa.landlordGateway.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Landlord {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public Landlord() {
	}

	public Landlord(String firstName, String lastName, String email, String testContactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = testContactNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean matches(Landlord landlord) {

		Boolean firstCheck = this.getFirstName().contentEquals(landlord.getFirstName()) ;
		Boolean firstNull = landlord.getFirstName().contentEquals("N/A");
		Boolean lastCheck = this.getLastName().contentEquals(landlord.getLastName());
		Boolean lastNull = landlord.getLastName().contentEquals("N/A");
		
		firstCheck = firstCheck||firstNull;
		lastCheck = lastCheck||lastNull;
		return (firstCheck && lastCheck);
	}
	
	
}
