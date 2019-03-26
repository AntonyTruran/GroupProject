package com.qa.tenantApi.main.entities;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TenantBuilder {
	private static TenantBuilder tenantBuilder;

	private String firstName = "";
	private String lastName = "";
	private String contactNumber = "";
	private String contactEmail = "";
	private String QaEmail = "";
	private String roomReference = "";
	private String groupName = "";
	private String startDate = "";
	private String endDate = "";
	private String notes = "";

	private TenantBuilder() {
	}

	public static TenantBuilder getTenantBuilder() {
		if (tenantBuilder == null) {
			tenantBuilder = new TenantBuilder();
		}
		return tenantBuilder;
	}

	public void firstName(String firstName) {
		this.firstName = firstName;
	}

	public void lastName(String lastName) {
		this.lastName = lastName;
	}

	public void contactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void contactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public void qaEmail(String qaEmail) {
		QaEmail = qaEmail;
	}

	public void roomReference(String roomReference) {
		this.roomReference = roomReference;
	}

	public void groupName(String groupName) {
		this.groupName = groupName;
	}

	public void startDate(String startDate) {
		this.startDate = startDate;
	}

	public void endDate(String endDate) {
		this.endDate = endDate;
	}

	public void notes(String notes) {
		this.notes = notes;
	}
	
	public Tenant tennantBuild() {
		Tenant tenant = new Tenant(
				Optional.ofNullable(this.firstName).orElse("N/A"),
				Optional.ofNullable(this.lastName).orElse("N/A"),
				Optional.ofNullable(this.contactNumber).orElse("N/A"),
				Optional.ofNullable(this.contactEmail).orElse("N/A"),
				Optional.ofNullable(this.QaEmail).orElse("N/A"),
				Optional.ofNullable(this.roomReference).orElse("N/A"),
				Optional.ofNullable(this.groupName).orElse("N/A"),
				Optional.ofNullable(this.startDate).orElse("N/A"),
				Optional.ofNullable(this.endDate).orElse("N/A"),
				Optional.ofNullable(this.notes).orElse("N/A")
				);
		tenantBuilder= new TenantBuilder();
		return tenant;
	}
}
