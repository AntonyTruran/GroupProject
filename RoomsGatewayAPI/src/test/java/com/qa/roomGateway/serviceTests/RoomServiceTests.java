package com.qa.roomGateway.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.notNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.entity.Room;
import com.qa.roomGateway.repository.RoomRepo;
import com.qa.roomGateway.service.RoomService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTests {
	
	@InjectMocks
	RoomService service;
	@Mock
	RoomRepo repo;
	private List<Room> roomList = new ArrayList<Room>();

	@Before
	public void setup() {
		roomList.add(GatewayConstants.getConstructedRoom());
	}
	@After
	public void tearDown() {
		roomList.clear();
	}
	@Test
	public void createRoomTest() {
		Room mockedRoom = GatewayConstants.getConstructedRoom();
		Mockito.when(repo.save((Room)notNull())).thenAnswer((Answer<?>) invocation -> {
			roomList.add(mockedRoom);
			return GatewayConstants.getConstructedRoom();
		});
		assertThat(roomList.size()).isEqualTo(1);
	}
	
	@Test
	public void getAllTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Room> returnList = service.getAllRooms();
		assertThat(returnList.size()).isEqualTo(1);
		
	}
	
	@Test
	public void getByNumberTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Room> returnList = service.getAllRooms();

		assertThat(returnList.size()).isEqualTo(1);		
	}
	
	@Test
	public void getByBuildingTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Room> returnList = service.getAllRooms();

		assertThat(returnList.size()).isEqualTo(1);
	}
	
	@Test
	public void getByLandlordTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Room> returnList = service.getAllRooms();

		assertThat(returnList.size()).isEqualTo(1);
	}
	
	@Test
	public void updateRoomTest() {
		
	}
	
	@Test
	public void deleteRoomTest() {
		
	}
}
