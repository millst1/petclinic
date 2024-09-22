package com.petclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petclinic.bean.Pet;

@Repository
public interface PetDao extends JpaRepository<Pet, Integer>{

}
