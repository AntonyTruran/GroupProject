package com.qa.tenantApi.main.testMain.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.tenantApi.main.controllers.TenantController;
import com.qa.tenantApi.main.entities.Tenant;
import com.qa.tenantApi.main.entities.TenantBuilder;
import com.qa.tenantApi.main.service.TenantService;
import com.qa.tenantApi.main.testMain.Constants;

@RunWith(SpringRunner.class)
@WebMvcTest(TenantController.class)
@AutoConfigureMockMvc
public class TenantControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TenantService service;
	@MockBean
	private TenantBuilder builder;
	@MockBean
	RestTemplateBuilder rtb;
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	private Tenant testTenant;
	
	@Before
	public void setUp() {
		testTenant = Constants.getConstructedTenant();
	}
	
	@Ignore
	@Test
	public void testTenantCreation() throws Exception {
		Mockito.when(service.createTenant((Tenant)notNull())).thenReturn("Tenant created");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/createTenant").param("firstName", "first").param("lastName", "last")
				.param("accountNum", "b12345")).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains("Account created");
	}
	
	@Test
	public void testGetAllTenants() throws Exception {
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(Constants.getConstructedTenant());
		when(service.getAllTenants()).thenReturn(MOCKED_TENANTS);
		mockMvc.perform(get("/getAllTenants")).andExpect(content().string(containsString("TestFirst")));
	}
	
	@Test
	public void testTenantSearch() throws Exception {
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(testTenant);
		MOCKED_TENANTS.add(Constants.getDefaultBuilderTenant());
		
		Mockito.when(service.tenantSearch((Tenant) notNull()))
				.thenReturn(MOCKED_TENANTS.stream().filter(x -> x.matches(testTenant)).collect(Collectors.toList()));
		MvcResult result = mockMvc.perform(get("/tenantSearch").param("firstName", "TestFirst").param("lastName","TestLast").param("groupName", "TestGroupName").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		TypeReference<List<Tenant>> mapType = new TypeReference<List<Tenant>>() {};
		System.out.println(content);
		List<Tenant> list = OBJECT_MAPPER.readValue(content, mapType);
		assertThat(list.stream().filter(x -> x.matches(testTenant)).collect(Collectors.toList()).get(0).matches(testTenant));
	}
}
