package com.qa.tenantApi.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.repository.TenantRepo;

@Service
public class TenantService {

	private TenantRepo tenantRepo;

	public TenantService(TenantRepo tenantRepo) {
		this.tenantRepo = tenantRepo;
	}

	public List<Tenant> getAllTenants() {
		return this.tenantRepo.findAll();
	}
	
	public List<Tenant> tenantSearch(Tenant tenant){
		return this.getAllTenants().stream().filter(x->x.matches(tenant)).collect(Collectors.toList());
	}
	
	public String createTenant(Tenant tenant) {
		this.tenantRepo.save(tenant);
		return "New Tenant Created";
	}
	
	public String deleteTenant(Tenant tenant) {
		this.tenantRepo.delete(tenant);
		return "Tenant deleted";
	}
	
	public String deleteTenantGroup(List<Tenant> tenants) {
		this.tenantRepo.deleteAll(tenants);;
		return "Tenant deleted";
	}
	
	public String deleteAllTenants() {
		this.tenantRepo.deleteAll();
		return "All Tenants deleted";
	}
	
	public String updateTenant(Tenant tenant) {
		this.tenantRepo.saveAndFlush(tenant);
		return "Tenant upated";
	}
	
	public String updateTenantGroup(List<Tenant> tenants) {
		this.tenantRepo.saveAll(tenants);
		return "Tenant group upated";
	}
}
