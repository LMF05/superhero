package com.superhero.sup.service;

import java.util.List;

import com.superhero.sup.dto.SuperheroDTO;
import com.superhero.sup.entity.SuperheroEntity;

public interface SuperheroService {

	List<SuperheroDTO> getAllSuperheroes();
	
	SuperheroDTO getSuperhero(Long id);
	
	List<SuperheroDTO> getSuperheroContainingSubstring(String substring);
	
	SuperheroDTO modifySuperhero(SuperheroEntity superhero);
	
	void deleteSuperhero(Long id);
}
