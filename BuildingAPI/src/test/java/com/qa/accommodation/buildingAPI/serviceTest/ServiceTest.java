package com.qa.accommodation.buildingAPI.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.accommodation.buildingAPI.Constants;
import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.repository.BuildingRepo;
import com.qa.accommodation.buildingAPI.service.BuildingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	@InjectMocks
	BuildingService buildingService;
	
	@Mock
	BuildingRepo buildingRepo;
	
	private List<Building> buildingList = new ArrayList<Building>();
	
	@Before
	public void setup() {
		buildingList.add(Constants.getBuildingBuilder());
	}
}
