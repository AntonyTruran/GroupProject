package com.qa.roomGateway.entityTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.entity.Event;
import com.qa.roomGateway.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentEntityTests {
	@Test
	public void apartmentSuperConstructorTest() {
		Apartment apartment = new Apartment();
		assertThat(apartment).isNotNull();
	}
	@Test
	public void apartmentGetterTest(){
		assertNull(GatewayConstants.getNullApartment().getBuilding());
		assertNull(GatewayConstants.getNullApartment().getApartmentNumber());
		assertNull(GatewayConstants.getNullApartment().getRooms());
		assertNull(GatewayConstants.getNullApartment().getCurrentState());
		assertNull(GatewayConstants.getNullApartment().getLandlord());
	}
	@Test
	public void apartmentSettterTest() {
		Apartment testApartment = GatewayConstants.getNullApartment();
		testApartment.setBuilding(GatewayConstants.getNaString());
		testApartment.setApartmentNumber(1301);
		testApartment.setRooms(null);
		testApartment.setCurrentState(GatewayConstants.getNaString());
		testApartment.setLandlord(GatewayConstants.getNaString());
	}
	@Test
	public void roomSuperConstructorTest() {
		Room room = new Room();
		assertThat(room).isNotNull();
	}
	@Test
	public void roomSetterTest() {
		Room testRoom = GatewayConstants.getNullRoom();
		testRoom.setRoomName(GatewayConstants.getNaString());
		testRoom.setEvents(null);
	}
	
	@Test
	public void roomGetterTest() {
		assertNull(GatewayConstants.getNullRoom().getEvents());
		assertNull(GatewayConstants.getNullRoom().getRoomName());
	}
	@Test
	public void eventSetterTest() {
		Event testEvent = GatewayConstants.getNullEvent();
		testEvent.setTitle(GatewayConstants.getNaString());
//		testEvent.setEndDate(GatewayConstants.getNaString());
//		testEvent.setStartDate(GatewayConstants.getNaString());
	}
	@Test
	public void eventGetterTest() {
		assertNull(GatewayConstants.getNullEvent().getEndDate());
		assertNull(GatewayConstants.getNullEvent().getStartDate());
		assertNull(GatewayConstants.getNullEvent().getTitle());
	}
}
