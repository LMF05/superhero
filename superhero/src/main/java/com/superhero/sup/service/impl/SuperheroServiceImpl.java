package com.superhero.sup.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.sup.dto.SuperheroDTO;
import com.superhero.sup.entity.SuperheroEntity;
import com.superhero.sup.mapper.SuperheroMapper;
import com.superhero.sup.repository.SuperheroRepository;
import com.superhero.sup.service.SuperheroService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SuperheroServiceImpl implements SuperheroService{

	@Autowired
	private SuperheroRepository repository;
	
	private static SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);
	
	@Override
	public List<SuperheroDTO> getAllSuperheroes(){
		List<SuperheroDTO> superheroesDTO = new ArrayList<>();
		return superheroesDTO;
	}
	
	@Override
	public SuperheroDTO getSuperhero(Long id){
		SuperheroDTO superheroDTO = new SuperheroDTO();	
		return superheroDTO;
	}
	
	@Override
	public List<SuperheroDTO> getSuperheroContainingSubstring(String substring){
		List<SuperheroDTO> superheroesDTO = new ArrayList<>();
		return superheroesDTO;
	}
	
	@Override
	@Transactional
	public SuperheroDTO modifySuperhero(SuperheroEntity superhero){
		SuperheroDTO superheroDTO = new SuperheroDTO();	
		return superheroDTO;
	}
	
	@Override
	@Transactional
	public void deleteSuperhero(Long id){
		log.debug("Deleting the superhero");
		repository.deleteById(id);
		log.debug("Superhero deleted");
	}
}
