package com.superhero.sup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.superhero.sup.entity.SuperheroEntity;

@Repository
public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long>{

	@Query("SELECT s FROM SuperheroEntity s WHERE lower(s.name) LIKE lower(CONCAT('%',:name,'%'))")
	List<SuperheroEntity> findSuperheroByNameLike(@Param("name") String name);
	
}
