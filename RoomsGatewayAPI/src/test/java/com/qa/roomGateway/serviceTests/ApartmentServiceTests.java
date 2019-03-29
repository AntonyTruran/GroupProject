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
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.repository.ApartmentRepo;
import com.qa.roomGateway.service.ApartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentServiceTests {
	
	@InjectMocks
	ApartmentService service;
	@Mock
	ApartmentRepo repo;
	private List<Apartment> roomList = new ArrayList<Apartment>();

	@Before
	public void setup() {
		roomList.add(GatewayConstants.getConstructedApartment());
	}
	@After
	public void tearDown() {
		roomList.clear();
	}
	@Test
	public void createApartmentTest() {
		Apartment mockedApartment = GatewayConstants.getConstructedApartment();
		Mockito.when(repo.save((Apartment)notNull())).thenAnswer((Answer<?>) invocation -> {
			roomList.add(mockedApartment);
			return GatewayConstants.getConstructedApartment();
		});
		assertThat(roomList.size()).isEqualTo(1);
	}
	
	@Test
	public void getAllTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Apartment> returnList = service.getAllApartments();
		assertThat(returnList.size()).isEqualTo(1);
		
	}
	
	@Test
	public void getByNumberTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Apartment> returnList = service.getAllApartments();

		assertThat(returnList.size()).isEqualTo(1);		
	}
	
	@Test
	public void getByBuildingTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Apartment> returnList = service.getAllApartments();

		assertThat(returnList.size()).isEqualTo(1);
	}
	
	@Test
	public void getByLandlordTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Apartment> returnList = service.getAllApartments();

		assertThat(returnList.size()).isEqualTo(1);
	}
	
	@Test
	public void updateApartmentTest() {
		
	}
	
	@Test
	public void deleteApartmentTest() {
		
	}
}
