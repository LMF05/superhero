package com.superhero.sup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.sup.dto.SuperheroDTO;
import com.superhero.sup.entity.SuperheroEntity;
import com.superhero.sup.service.SuperheroService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SuperheroController {

	@Autowired
	private SuperheroService service;
	
	@GetMapping("/superhero/getAllSuperheroes")
	public List<SuperheroDTO> getAllSuperheroes(){
		log.debug("Getting all superheroes");
		List<SuperheroDTO> superheroes = service.getAllSuperheroes();
		log.debug("Returning the data");
		return superheroes;
	}
	
	@GetMapping("/superhero/getSuperhero")
	public SuperheroDTO getSuperhero(@RequestParam Long id){
		log.debug("Getting superhero");
		SuperheroDTO superhero = service.getSuperhero(id);
		log.debug("Returning the data");
		return superhero;
	}
	
	@GetMapping("/superhero")
	public List<SuperheroDTO> getSuperheroByParameter(@RequestParam String substring){
		log.debug("Getting superhero");
		List<SuperheroDTO> superheroes = service.getSuperheroContainingSubstring(substring);
		log.debug("Returning the data");
		return superheroes;
	}
	
	@PutMapping("/superhero/modifySuperhero")
	public SuperheroDTO modifySuperhero(@RequestBody SuperheroEntity superhero){
		log.debug("Modifying superhero");
		SuperheroDTO superheroDTO = service.modifySuperhero(superhero);
		log.debug("Returning the data");
		return superheroDTO;
	}
	
	@PostMapping("/superhero/deleteSuperhero")
	public ResponseEntity<String> deleteSuperhero(@RequestParam Long id) {
		log.debug("Deleting superhero");
		service.deleteSuperhero(id);
		log.debug("Returning the data");
		return new ResponseEntity<String>("Superhero deleted!", HttpStatus.OK);
	}
}
