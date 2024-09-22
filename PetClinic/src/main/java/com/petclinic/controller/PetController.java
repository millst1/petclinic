package com.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.petclinic.bean.Pet;
import com.petclinic.service.PetService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PetController {

	@Autowired
	PetService petService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openFirstPage() {
		return "index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String addPetPage(Pet pet, Model model) {
		model.addAttribute("pp", pet);
		return "add";
	}
	
	@RequestMapping(value = "addPet",method = RequestMethod.POST)
	public String addPetUsingHttpServlet(HttpServletRequest req, Pet pet, Model model) {
		
		String petName = req.getParameter("petName");
		String ownerName = req.getParameter("ownerName");
		int petAge = Integer.parseInt(req.getParameter("petAge"));
		
		pet.setPetName(petName);
		pet.setOwnerName(ownerName);
		pet.setPetAge(petAge);
		
		String result = petService.storePet(pet);
			model.addAttribute("msg", result);
			model.addAttribute("pp", pet);
		
		return "add";
	}
	
	
	@RequestMapping(value = "addPetInDb",method = RequestMethod.POST)
	public String addPetInDbUsingThymeleafForm(Pet pet, Model model) {
		String result = petService.storePet(pet);
		model.addAttribute("pp", pet);
			model.addAttribute("msg", result);
		
		return "add";
	}
	
	@RequestMapping(value = "viewPets",method = RequestMethod.GET)
	public String viewPets(Model model) {
		List<Pet> listOfPets = petService.findAllPets();
		model.addAttribute("pets", listOfPets);
		return "view";
	}
}







