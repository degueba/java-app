package com.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infnet.appvenda.model.domain.Mobilia;

@Repository
public interface MobiliaRepository extends CrudRepository<Mobilia, Integer> {
	
}
