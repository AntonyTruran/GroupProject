package com.qa.roomGateway.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.roomGateway.entity.Apartment;

import io.micrometer.core.lang.Nullable;

@Repository
public interface ApartmentRepo extends MongoRepository<Apartment, String>{
	public List<Apartment> findByApartmentNumber(int apartmentNumber);

	public List<Apartment> findByBuilding(String building);
	
	public List<Apartment> getApartmentsByLandlord(String request);
	public List<Apartment> getApartmentsByLandlord();
	
}
