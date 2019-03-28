package com.qa.roomGateway.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.entity.Room;
import com.qa.roomGateway.service.RoomService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomGatewayTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	RoomService service;
	@MockBean
	RestTemplateBuilder rtb;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private List<Room> roomList = new ArrayList<Room>();
	private Room testRoom;

	@Before
	public void setUp() {
		roomList.add(GatewayConstants.getConstructedRoom());
		testRoom = GatewayConstants.getConstructedRoom();
	}
	@Test
	public void addRoomTest() throws Exception {
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testRoom);
		Mockito.when(service.addRoom((Room)notNull())).thenReturn("New Tenant Created");
		MvcResult result = mvc.perform(post("/createRoom").contentType(APPLICATION_JSON_UTF8)
				.content(postContent)).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains("New Tenant Created");
	}

	@Test
	public void getAllTest() throws Exception {
		when(service.getAllRooms()).thenReturn(roomList);
		assertThat(mvc.perform(get("/getAllRooms").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("numberOne"))));
	}

	@Test
	public void getRoomsByNumberTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedRoom());
		when(service.getRoomsByNumber(0)).thenReturn(roomList);
		assertThat(mvc.perform(get("/getRoomByNumber/").param("request", "1301").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("")));
	}

	@Test
	public void getRoomByBuildingTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedRoom());
		when(service.getRoomsByBuilding("numberOne")).thenReturn(roomList);
		assertThat(
				mvc.perform(get("/getRoomByBuilding/").param("request", "numberOne").accept(MediaType.APPLICATION_JSON))
						.andExpect(content().string("")));
	}

	@Test
	public void getRoomByLandlordTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedRoom());
		when(service.getRoomsByLandlord("Jason Joans")).thenReturn(roomList);
		assertThat(mvc
				.perform(get("/getRoomByLandlord/").param("request", "Jason Joans").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("")));
	}

	@Test
	public void updateRoomTest() {

	}
	@Ignore
	@Test
	public void deleteRoomTest() throws Exception {
		assertThat( mvc.perform(post("/removeRoom").contentType(Room testRoom).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()));
	}
}
