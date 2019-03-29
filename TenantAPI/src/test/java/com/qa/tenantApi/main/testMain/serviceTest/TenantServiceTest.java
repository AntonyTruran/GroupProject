package com.qa.tenantApi.main.testMain.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.tenantApi.main.Constants;
import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.entities.TenantBuilder;
import com.qa.tenantApi.main.repository.TenantRepo;
import static org.mockito.ArgumentMatchers.*;
import com.qa.tenantApi.main.service.TenantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TenantServiceTest {
	@InjectMocks
	TenantService tenantService;
	@Mock
	TenantRepo tenantRepo;
	
	private List<Tenant> tenantList = new ArrayList<Tenant>();

	@Before
	public void setup() {
		tenantList.add(Constants.getDefaultBuilderTenant());
		tenantList.add(Constants.getConstructedTenant());  
	}

	@After
	public void deconstruct() {
		Tenant tenant = TenantBuilder.getTenantBuilder().tenantBuild();
		Constants.setDefaultBuilderTenant(tenant);
		tenantList.clear();
	}

	@Test
	public void getAllTest() {
		Mockito.when(tenantRepo.findAll()).thenReturn(tenantList);
		List<Tenant> returnList = tenantService.getAllTenants();

		assertThat(returnList.size()).isEqualTo(2);
		assertThat(returnList.get(0)).isEqualToComparingFieldByField(Constants.getDefaultBuilderTenant());
		assertThat(returnList.get(1)).isEqualToComparingFieldByField(Constants.getConstructedTenant());
	}
	 
	@Test
	public void createTenantTest() {
		Tenant newTenant = Constants.getConstructedTenant();
		Mockito.when(tenantRepo.save((Tenant)notNull())).thenAnswer((Answer<?>) invocation -> {
			tenantList.add(newTenant);
			return Constants.getNullTenant();
		});
		assertThat(tenantService.createTenant(newTenant)).isEqualTo(Constants.getCreationMessage());
		assertThat(tenantList.size()).isEqualTo(3);
		assertThat(tenantList.get(2)).isEqualToComparingFieldByField(Constants.getConstructedTenant());
	}
	
	@Test
	public void tenantSearchTest() {
		Tenant searchTenant = Constants.getConstructedTenant();
		Mockito.when(tenantRepo.findAll()).thenReturn(tenantList);
		assertThat(tenantService.tenantSearch(searchTenant).size()).isEqualTo(1);
		assertThat(tenantService.tenantSearch(searchTenant).get(0)).isEqualToComparingFieldByField(searchTenant);
	}
	
	@Test
	public void deleteTenantTest() {
		Mockito.when(tenantService.deleteTenant((Tenant)notNull())).thenAnswer((Answer<?>) invocation -> {
			tenantList.remove(Constants.getDefaultBuilderTenant());
			return Constants.getDeletionMessage();
		});
		assertThat(tenantService.deleteTenant(Constants.getDefaultBuilderTenant())).isEqualTo(Constants.getDeletionMessage());
		assertThat(tenantList.contains(Constants.getDefaultBuilderTenant())).isEqualTo(false);
		
	}
	
	@Test
	public void deleteAllTest() {
		Mockito.when(tenantService.deleteAllTenants()).thenAnswer((Answer<?>) invocation -> {
			tenantList.clear();
			return Constants.getAllDeletionMessage();
		});
		assertThat(tenantService.deleteAllTenants()).isEqualTo(Constants.getAllDeletionMessage());
		assertThat(tenantList.size()).isEqualTo(0);
	}
	
	@Test
	public void updateTenantTest() throws CloneNotSupportedException {
		Tenant updateTenant = Constants.getConstructedTenant();
		Mockito.when(tenantRepo.findById((Long)notNull())).thenReturn(Optional.ofNullable(tenantList.get(0)));
		Mockito.when(tenantRepo.saveAndFlush((Tenant)notNull())).thenAnswer((Answer<?>) invocation -> {
			tenantList.clear();
			tenantList.add(updateTenant);
			tenantList.add(Constants.getConstructedTenant());  
			return updateTenant;
		});

		Long index = Long.valueOf(String.valueOf(0));
		tenantService.updateTenant(index, updateTenant);
		assertThat(tenantList.get(0).matches(Constants.getConstructedTenant()));
	}
}
