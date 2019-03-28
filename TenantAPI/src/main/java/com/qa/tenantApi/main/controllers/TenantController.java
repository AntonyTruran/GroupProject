package com.qa.tenantApi.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tenantApi.main.Constants;
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
	
	@GetMapping("/tenantGroupSearch/{groupName}")
	public List<Tenant> tenantGroupSearch(@PathVariable("groupName")String groupName) {
		Tenant tenant = TenantBuilder.getTenantBuilder().groupName(groupName).tenantBuild();
		return this.tenantService.tenantSearch(tenant);
	}
	
	@DeleteMapping("/deleteAllTenants")
	public String deleteAllTenants() {
		return this.tenantService.deleteAllTenants();
	}
	
	@DeleteMapping("/deleteTenantGroup/{groupName}")
	public String deleteTenantGroup(@PathVariable("groupName") String groupName) {
		List<Tenant> tenants = this.tenantGroupSearch(groupName);
		for(int i = 0; i < tenants.size();i++) {
			this.tenantService.deleteTenant(tenants.get(i));
		}
		return Constants.getGroupDeletionMessage();
	}
	
	@DeleteMapping("/deleteTenant")
	public String deleteTenant(String firstName, String lastName, String groupName) {
		List<Tenant> tenants = this.tenantSearch(firstName, lastName, groupName);
		for(int i = 0; i < tenants.size();i++) {
			this.tenantService.deleteTenant(tenants.get(i));
		}
		return Constants.getTenantsDeletionMessage();
	}
	
	@PutMapping("/updateTenant/{id}")
	public String updateTenant(@PathVariable("id")long id, @RequestBody Tenant tenantUpdate) {
		return this.tenantService.updateTenant(id, tenantUpdate);
	}
	
	@PutMapping("/updateTenantGroup/{groupName}")
	public String updateTenant(@PathVariable("groupName") String setGroupName, @RequestBody Tenant tenantUpdate) {
		List<Tenant> tenants = this.tenantGroupSearch(setGroupName);
		return this.tenantService.updateTenantGroup(tenants, tenantUpdate);
	}
}
