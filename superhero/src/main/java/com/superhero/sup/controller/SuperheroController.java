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
import com.superhero.sup.exception.SuperheroException;
import com.superhero.sup.service.SuperheroService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SuperheroController {

	@Autowired
	private SuperheroService service;
	
	@GetMapping("/getAllSuperheroes")
	public ResponseEntity<Object> getAllSuperheroes() throws SuperheroException{
		log.debug("Getting all superheroes");
		List<SuperheroDTO> superheroes = service.getAllSuperheroes();
		log.debug("Returning the data");
		return new ResponseEntity<Object>(superheroes, HttpStatus.OK);
	}
	
	@GetMapping("/getSuperhero")
	public ResponseEntity<Object> getSuperhero(@RequestParam Long id){
		SuperheroDTO superhero;
		try {
			log.debug("Getting superhero");
			superhero = service.getSuperhero(id);
			log.debug("Returning the data");
		} catch (SuperheroException e) {
			return new ResponseEntity<Object>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(superhero, HttpStatus.OK);
	}
	
	@GetMapping("/getSuperheroByParameter")
	public ResponseEntity<Object> getSuperheroByParameter(@RequestParam String substring){
		log.debug("Getting superhero");
		List<SuperheroDTO> superheroes = service.getSuperheroContainingSubstring(substring);
		log.debug("Returning the data");
		return new ResponseEntity<Object>(superheroes, HttpStatus.OK);
	}
	
	@PutMapping("/modifySuperhero")
	public ResponseEntity<Object> modifySuperhero(@RequestBody SuperheroEntity superhero){
		log.debug("Modifying superhero");
		SuperheroDTO superheroDTO = service.modifySuperhero(superhero);
		log.debug("Returning the data");
		return new ResponseEntity<Object>(superheroDTO, HttpStatus.OK);
	}
	
	@PostMapping("/deleteSuperhero")
	public ResponseEntity<String> deleteSuperhero(@RequestParam Long id) {
		try {
			log.debug("Deleting superhero");
			service.deleteSuperhero(id);
			log.debug("Returning the data");
		} catch (SuperheroException e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Superhero deleted!", HttpStatus.OK);
	}
}
