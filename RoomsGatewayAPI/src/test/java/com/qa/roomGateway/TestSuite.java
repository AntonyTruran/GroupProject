  package com.qa.roomGateway;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.roomGateway.controllerTests.RoomGatewayTests;
import com.qa.roomGateway.entityTests.RoomEntityTests;
import com.qa.roomGateway.repositoryTests.RoomRepositoryTest;
import com.qa.roomGateway.serviceTests.RoomServiceTests;
import com.qa.roomGateway.smokeTests.RoomsGatewayApiApplicationTests;

@RunWith(Suite.class)

@SuiteClasses({RoomRepositoryTest.class, RoomServiceTests.class,RoomGatewayTests.class,RoomsGatewayApiApplicationTests.class, RoomEntityTests.class})

@SpringBootTest
public class TestSuite {

}
