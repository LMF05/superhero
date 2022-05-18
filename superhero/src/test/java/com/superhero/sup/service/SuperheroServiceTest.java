package com.superhero.sup.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.superhero.sup.dto.SuperheroDTO;
import com.superhero.sup.entity.SuperheroEntity;
import com.superhero.sup.repository.SuperheroRepository;
import com.superhero.sup.service.impl.SuperheroServiceImpl;

@ExtendWith(SpringExtension.class)
public class SuperheroServiceTest {
	
	@Mock
	private SuperheroRepository repository;
	
	@InjectMocks
	private SuperheroServiceImpl superheroService;
	
	@Test
	public void getAllSuperheroesTest() {
		List<SuperheroEntity> superheroesEntity = new ArrayList<SuperheroEntity>();
		superheroesEntity.add(new SuperheroEntity((long) 1, "Aquaman", "DC"));
		superheroesEntity.add(new SuperheroEntity((long) 2, "Scarlet Witch", "Marvel"));
		superheroesEntity.add(new SuperheroEntity((long) 3, "Black Panther", "Marvel"));
		Mockito.when(repository.findAll()).thenReturn(superheroesEntity);
		List<SuperheroDTO> response = superheroService.getAllSuperheroes();
		assertEquals(response.size(), superheroesEntity.size());
	}
	
	@Test
	public void getSuperheroTest() {
		Optional<SuperheroEntity> entity = Optional.ofNullable(new SuperheroEntity((long) 1, "Aquaman", "DC"));
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(entity);
		SuperheroDTO response = superheroService.getSuperhero((long) 1);
		assertEquals(response.getName(), entity.get().getName());
	}	
	
	@Test
	public void getSuperheroContainingSubstringTest() {
		List<SuperheroEntity> superheroesEntity = new ArrayList<SuperheroEntity>();
		superheroesEntity.add(new SuperheroEntity((long) 1, "Aquaman", "DC"));
		superheroesEntity.add(new SuperheroEntity((long) 2, "Batman", "DC"));
		superheroesEntity.add(new SuperheroEntity((long) 3, "Superman", "DC"));
		Mockito.when(repository.findSuperheroByNameLike(Mockito.anyString())).thenReturn(superheroesEntity);
		List<SuperheroDTO> response = superheroService.getSuperheroContainingSubstring("man");
		assertEquals(response.size(), superheroesEntity.size());
	}	
	
	@Test
	public void modifySuperheroTest() {
		SuperheroEntity entity = new SuperheroEntity((long) 1, "Aquaman", "DC");
		Mockito.when(repository.saveAndFlush(Mockito.any(SuperheroEntity.class))).thenReturn(entity);
		SuperheroDTO response = superheroService.modifySuperhero(entity);
		assertEquals(response.getName(), entity.getName());
	}
	
	@Test
	public void deleteSuperheroTest() {
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {

	            return null;
	        }
	    }).when(repository).deleteById(Mockito.anyLong());
		superheroService.deleteSuperhero(Long.valueOf(1));
		verify(repository, times(1)).deleteById(Long.valueOf(1));
	}
}
