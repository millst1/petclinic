package com.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.bean.Pet;
import com.petclinic.dao.PetDao;

@Service
public class PetService {

	@Autowired
	PetDao PetDao;
	
	public String storePet(Pet pet) {
		Optional<Pet> result = PetDao.findById(pet.getId());
		if(result.isPresent()) {
			return "Booking id must be unique";
		}else {
			PetDao.save(pet);
			return "Booking information stored in database";
		}
	}
	
	public List<Pet> findAllPets() {
		return PetDao.findAll();
	}	
}


