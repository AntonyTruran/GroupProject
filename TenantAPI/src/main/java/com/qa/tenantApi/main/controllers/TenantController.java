package com.qa.tenantApi.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.entities.TenantBuilder;
import com.qa.tenantApi.main.service.TenantService;

@RestController
@CrossOrigin
public class TenantController {

	private TenantService tenantService;

	public TenantController(TenantService tenantService) {
		this.tenantService = tenantService;
	}

	@PostMapping("/createTenant")
	public String createTenant(@RequestBody Tenant tenant) {
		return this.tenantService.createTenant(tenant);
	}

	@GetMapping("/getAllTenants")
	public List<Tenant> getAllTenants() {
		return this.tenantService.getAllTenants();
	}

	@GetMapping("/tenantSearch")
	public List<Tenant> tenantSearch(String firstName, String lastName, String groupName) {
		Tenant tenant = TenantBuilder.getTenantBuilder().firstName(firstName).lastName(lastName).groupName(groupName).tenantBuild();
		return this.tenantService.tenantSearch(tenant);
	}	
}
