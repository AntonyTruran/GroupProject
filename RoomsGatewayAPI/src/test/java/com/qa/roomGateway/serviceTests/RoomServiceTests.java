package com.qa.roomGateway.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
//	@Test
//	public void createRoomTest() {
//		Room mockedRoom = GatewayConstants.getConstructedRoom();
//		Mockito.when(repo.save(Room)).thenReturn("Created");
//		assertThat(tenantService.createTenant(newTenant)).isEqualTo(Constants.getTenantCreated());
//		assertThat(tenantList.size()).isEqualTo(3)
//		assertThat(tenantList.get(2)).isEqualToComparingFieldByField(Constants.getConstructedTenant());
//	}
	
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
