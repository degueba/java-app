package com.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infnet.appvenda.model.domain.Vendedor;
import java.util.List;

import org.springframework.data.domain.Sort;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer>{
	
	Vendedor findByCpf(String cpf);

	List<Vendedor> findAll(Sort sort);
	
}
