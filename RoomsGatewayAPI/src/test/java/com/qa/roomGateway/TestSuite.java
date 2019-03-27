  package com.qa.roomGateway;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.roomGateway.repositoryTests.RoomRepositoryTest;
import com.qa.roomGateway.serviceTests.RoomServiceTests;

@RunWith(Suite.class)

@SuiteClasses({RoomRepositoryTest.class, RoomServiceTests.class})

@SpringBootTest
public class TestSuite {

}
