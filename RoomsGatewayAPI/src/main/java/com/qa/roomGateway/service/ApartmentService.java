package com.qa.roomGateway.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.repository.ApartmentRepo;

@Service
public class ApartmentService {

	public ApartmentService(ApartmentRepo repo) {
		this.repo = repo;
	}

	private ApartmentRepo repo;

	public String addApartment(Apartment apartment) {
		System.out.println(apartment.getRooms());
		repo.save(apartment);
		return "{\"message\":\"apartment added\"}";
	}

	public List<Apartment> getAllApartments() {
		return this.repo.findAll();
	}

	public List<Apartment> getApartmentsByNumber(int request) {
		return this.repo.findByApartmentNumber(request);
	}

	public List<Apartment> getApartmentsByBuilding(String request) {
		return this.repo.findByBuilding(request);
	}

	public List<Apartment> getApartmentsByLandlord(String request) {
		return this.repo.getApartmentsByLandlord(request);
	}

//	public String updateApartment(String apartmentReference, Apartment updatedApartment) {
//		Apartment currentDetails = this.repo.getApartmentByApartmentId(updatedApartment.getApartmentId());
//		currentDetails.setCurrentState(updatedApartment.getCurrentState());
//		currentDetails.setLandlord(updatedApartment.getLandlord());
//		repo.save(currentDetails);
//		return "{\"message\":\"apartment updated\"}";
//	}
//	public ResponseEntity<List<Apartment>> deleteApartment(Integer apartmentNumber) {
//		List<Apartment> apartment = repo.delete(repo.findByApartmentNumber(apartmentNumber));
//		return new ResponseEntity<List<Apartment>>(apartment, HttpStatus.OK);
//	}
}
