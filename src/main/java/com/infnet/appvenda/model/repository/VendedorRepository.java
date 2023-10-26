package com.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infnet.appvenda.model.domain.Vendedor;


@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer>{
	
	 
	
}
