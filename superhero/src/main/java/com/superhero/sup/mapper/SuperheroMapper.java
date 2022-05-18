package com.superhero.sup.mapper;

import org.mapstruct.Mapper;

import com.superhero.sup.dto.SuperheroDTO;
import com.superhero.sup.entity.SuperheroEntity;

@Mapper
public interface SuperheroMapper {

	SuperheroDTO entityToDto(SuperheroEntity entity);
	
}
