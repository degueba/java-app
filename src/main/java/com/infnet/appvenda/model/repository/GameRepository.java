package com.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infnet.appvenda.model.domain.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
	
}
