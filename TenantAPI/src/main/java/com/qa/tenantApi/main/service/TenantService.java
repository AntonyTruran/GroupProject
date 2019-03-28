package com.qa.tenantApi.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.tenantApi.main.Constants;
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
		return Constants.getCreationMessage();
	}
	
	public String deleteTenant(Tenant tenant) {
		this.tenantRepo.delete(tenant);
		return Constants.getDeletionMessage();
	}
	
	public String deleteAllTenants() {
		this.tenantRepo.deleteAll();
		return Constants.getAllDeletionMessage();
	}
	
	public String updateTenant(Long id, Tenant updateTenant) {
		Tenant tenantToUpdate = this.tenantRepo.findById(id).orElse(new Tenant());
		tenantToUpdate.setFirstName(Optional.ofNullable(updateTenant.getFirstName()).orElse(Optional.ofNullable(tenantToUpdate.getFirstName()).orElse(Constants.getNaString())));
		tenantToUpdate.setLastName(Optional.ofNullable(updateTenant.getLastName()).orElse(Optional.ofNullable(tenantToUpdate.getLastName()).orElse(Constants.getNaString())));
		tenantToUpdate.setContactNumber(Optional.ofNullable(updateTenant.getContactNumber()).orElse(Optional.ofNullable(tenantToUpdate.getContactNumber()).orElse(Constants.getNaString())));
		tenantToUpdate.setContactEmail(Optional.ofNullable(updateTenant.getContactEmail()).orElse(Optional.ofNullable(tenantToUpdate.getContactEmail()).orElse(Constants.getNaString())));
		tenantToUpdate.setQaEmail(Optional.ofNullable(updateTenant.getQaEmail()).orElse(Optional.ofNullable(tenantToUpdate.getQaEmail()).orElse(Constants.getNaString())));
		tenantToUpdate.setRoomReference(Optional.ofNullable(updateTenant.getRoomReference()).orElse(Optional.ofNullable(tenantToUpdate.getRoomReference()).orElse(Constants.getNaString())));
		tenantToUpdate.setGroupName(Optional.ofNullable(updateTenant.getGroupName()).orElse(Optional.ofNullable(tenantToUpdate.getGroupName()).orElse(Constants.getNaString())));
		tenantToUpdate.setStartDate(Optional.ofNullable(updateTenant.getStartDate()).orElse(Optional.ofNullable(tenantToUpdate.getStartDate()).orElse(Constants.getNaString())));
		tenantToUpdate.setEndDate(Optional.ofNullable(updateTenant.getEndDate()).orElse(Optional.ofNullable(tenantToUpdate.getEndDate()).orElse(Constants.getNaString())));
		tenantToUpdate.setNotes(Optional.ofNullable(updateTenant.getNotes()).orElse(Optional.ofNullable(tenantToUpdate.getNotes()).orElse(Constants.getNaString())));
		this.tenantRepo.saveAndFlush(tenantToUpdate);
		return Constants.getUpdateMesssage();
	}
	
	public String updateTenantGroup(List<Tenant> tenants, Tenant updateTenant) {
		for(int i = 0; i<tenants.size();i++) {
			Tenant tenantToUpdate = tenants.get(i);
			this.updateTenant(tenantToUpdate.getId(),updateTenant);
		}
		return Constants.getGroupUpdateMessage();
	}
}
