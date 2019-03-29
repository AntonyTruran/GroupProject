package com.qa.roomGateway.entityTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomEntityTests {
	@Test
	public void superConstructorTest() {
		Room room = new Room();
		assertThat(room).isNotNull();
	}
	@Test
	public void getterTest(){
		assertEquals(0,GatewayConstants.getNullRoom().getRoomId());
		assertNull(GatewayConstants.getNullRoom().getBuilding());
		assertNull(GatewayConstants.getNullRoom().getRoomNumber());
		assertNull(GatewayConstants.getNullRoom().getEvents());
		assertNull(GatewayConstants.getNullRoom().getCurrentState());
		assertNull(GatewayConstants.getNullRoom().getLandlord());
	}
	@Test
	public void setttertest() {
		Room testRoom = GatewayConstants.getNullRoom();
		testRoom.setRoomId(1);
		testRoom.setBuilding(GatewayConstants.getNaString());
		testRoom.setRoomNumber(1301);
		testRoom.setEvents();
		testRoom.setCurrentState(GatewayConstants.getNaString());
		testRoom.setLandlord(GatewayConstants.getNaString());
	}
}
