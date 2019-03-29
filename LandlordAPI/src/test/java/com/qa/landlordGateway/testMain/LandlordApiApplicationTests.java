package com.qa.landlordGateway.testMain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.LandlordApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordApiApplicationTests {

	private LandlordApiApplication app;
	private TestSuite suite;
	private Constants constants;
	@Before
	public void setup() {
		app = new LandlordApiApplication();
		suite = new TestSuite();
		this.constants = new Constants();
	}
	@Test
	public void contextLoads() {
		String[] args = new String[] {"Hello World"};
		app.main(args);
	}
	

}
