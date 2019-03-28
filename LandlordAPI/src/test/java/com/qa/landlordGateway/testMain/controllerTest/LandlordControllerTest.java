package com.qa.landlordGateway.testMain.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.landlordGateway.controllers.LandlordController;
import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;
import com.qa.landlordGateway.service.LandlordService;
import com.qa.landlordGateway.testMain.Constants;
import com.fasterxml.jackson.databind.ObjectWriter;


@RunWith(SpringRunner.class)
@WebMvcTest(LandlordController.class)
@AutoConfigureWebMvc
public class LandlordControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LandlordService service;
	@MockBean
	private LandlordBuilder builder;
	@MockBean
	RestTemplateBuilder rtb;
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private Landlord testLandlord;
	
	@Before
	public void setUp() {
		testLandlord = Constants.getConstructedLandlord();
	}
	
	@Test
	public void testLandlordCreation() throws Exception {
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testLandlord);
		Mockito.when(service.createLandlord((Landlord)notNull())).thenReturn(Constants.getLandlordCreated());
		MvcResult result = mockMvc.perform(post("/createLandlord").contentType(APPLICATION_JSON_UTF8).content(postContent)).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains(Constants.getLandlordCreated());
	}
	
	@Test
	public void testGetAllLandlords() throws Exception {
		List<Landlord> MOCKED_LANDLORDS = new ArrayList<Landlord>();
		MOCKED_LANDLORDS.add(Constants.getConstructedLandlord());
		when(service.getLandlords()).thenReturn(MOCKED_LANDLORDS);
		assertThat(mockMvc.perform(get("/getAllLandlords").accept(MediaType.APPLICATION_JSON)).andExpect(content().string(containsString("TestFirst"))));
	}
	@Test
	public void testLandlordSearch() throws Exception {
		List<Landlord> MOCKED_LANDLORDS = new ArrayList<Landlord>();
		MOCKED_LANDLORDS.add(testLandlord);
		MOCKED_LANDLORDS.add(Constants.getDefaultBuilderLandlord());
		
		Mockito.when(service.landlordSearch((Landlord) notNull()))
				.thenReturn(MOCKED_LANDLORDS.stream().filter(x -> x.matches(testLandlord)).collect(Collectors.toList()));
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testLandlord);
		TypeReference<List<Landlord>> mapType = new TypeReference<List<Landlord>>() {};
		List<Landlord> list = OBJECT_MAPPER.readValue(postContent, mapType);
		assertThat(list.stream().filter(x -> x.matches(testLandlord)).collect(Collectors.toList()).get(0).matches(testLandlord));
	}
}
