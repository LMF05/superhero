package com.superhero.sup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		log.debug("Getting the data from repository");
		List<SuperheroEntity> superheroesEntity = repository.findAll();
		log.debug("Data obtained");
		List<SuperheroDTO> superheroesDTO = new ArrayList<>();
		log.debug("Mapping superhero to dto");
		for(SuperheroEntity s: superheroesEntity) {			
			superheroesDTO.add(superheroMapper.entityToDto(s));
		}
		log.debug("Returning the data");
		return superheroesDTO;
	}
	
	@Override
	public SuperheroDTO getSuperhero(Long id){
		log.debug("Getting the data from repository");
		Optional<SuperheroEntity> superheroesEntity = repository.findById(id);
		log.debug("Data obtained");
		SuperheroDTO superheroDTO;	
		log.debug("Mapping superhero to dto");
		superheroDTO = superheroMapper.entityToDto(superheroesEntity.get());	
		log.debug("Returning the data");
		return superheroDTO;
	}
	
	@Override
	public List<SuperheroDTO> getSuperheroContainingSubstring(String substring){
		log.debug("Getting the data from repository");
		List<SuperheroEntity> superheroesEntity = repository.findSuperheroByNameLike(substring);
		log.debug("Data obtained");
		List<SuperheroDTO> superheroesDTO = new ArrayList<>();
		log.debug("Mapping superhero to dto");
		for(SuperheroEntity s: superheroesEntity) {
			superheroesDTO.add(superheroMapper.entityToDto(s));
		}
		log.debug("Returning the data");
		return superheroesDTO;
	}
	
	@Override
	@Transactional
	public SuperheroDTO modifySuperhero(SuperheroEntity superhero){
		log.debug("Saving the superhero");
		SuperheroEntity superheroEntity = repository.saveAndFlush(superhero);
		log.debug("Superhero saved");
		SuperheroDTO superheroDTO;	
		log.debug("Mapping superhero to dto");
		superheroDTO = superheroMapper.entityToDto(superheroEntity);	
		log.debug("Returning the data");
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