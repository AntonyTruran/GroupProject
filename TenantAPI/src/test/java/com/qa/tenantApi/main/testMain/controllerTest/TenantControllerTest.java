package com.qa.tenantApi.main.testMain.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private Tenant testTenant;

	@Before
	public void setUp() {
		testTenant = Constants.getConstructedTenant();
	}

	@Test
	public void testTenantCreation() throws Exception {
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testTenant);
		Mockito.when(service.createTenant((Tenant) notNull())).thenReturn("New Tenant Created");
		MvcResult result = mockMvc
				.perform(post("/createTenant").contentType(APPLICATION_JSON_UTF8).content(postContent)).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains("New Tenant Created");
	}

	@Test
	public void testGetAllTenants() throws Exception {
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(Constants.getConstructedTenant());
		when(service.getAllTenants()).thenReturn(MOCKED_TENANTS);
		assertThat(mockMvc.perform(get("/getAllTenants").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("TestFirst"))));
	}

	@Test
	public void testTenantSearch() throws Exception {
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(testTenant);
		MOCKED_TENANTS.add(Constants.getDefaultBuilderTenant());

		Mockito.when(service.tenantSearch((Tenant) notNull()))
				.thenReturn(MOCKED_TENANTS.stream().filter(x -> x.matches(testTenant)).collect(Collectors.toList()));
		MvcResult result = mockMvc
				.perform(get("/tenantSearch").param("firstName", "TestFirst").param("lastName", "TestLast")
						.param("groupName", "TestGroupName").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		TypeReference<List<Tenant>> mapType = new TypeReference<List<Tenant>>() {
		};
		List<Tenant> list = OBJECT_MAPPER.readValue(content, mapType);
		assertThat(list.stream().filter(x -> x.matches(testTenant)).collect(Collectors.toList()).get(0)
				.matches(testTenant));
	}

	@Test
	public void testGroupSearch() {

	}

	@Test
	public void testDeleteAll() throws Exception {
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(testTenant);
		MOCKED_TENANTS.add(Constants.getDefaultBuilderTenant());
		Mockito.when(service.deleteAllTenants()).thenAnswer((Answer<?>) invocation -> {
			MOCKED_TENANTS.clear();
			return "All tenants deleted";
		});
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAllTenants").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		assertThat(MOCKED_TENANTS.size()).isEqualTo(0);
	}

	@Test
	public void testDeleteTenant() throws Exception {
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testTenant);
		
		List<Tenant> MOCKED_TENANTS = new ArrayList<Tenant>();
		MOCKED_TENANTS.add(testTenant);
		MOCKED_TENANTS.add(Constants.getDefaultBuilderTenant());
		
		Mockito.when(service.tenantSearch((Tenant) notNull())).thenReturn(MOCKED_TENANTS);
		Mockito.when(service.deleteTenant((Tenant) notNull())).thenAnswer((Answer<?>) invocation -> {
			MOCKED_TENANTS.remove(testTenant);
			return "Tenant deleted";
		});
		this.mockMvc.perform(MockMvcRequestBuilders
				.delete("/deleteTenant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(postContent))
		.andExpect(status().isOk());
		assertThat(MOCKED_TENANTS.size()).isEqualTo(1);
	}

	@Test
	public void testDeleteGroup() {

	}

	@Test
	public void testUpdateTenant() {

	}
}
