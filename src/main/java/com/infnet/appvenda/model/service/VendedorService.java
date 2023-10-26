package com.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.repository.VendedorRepository;


@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	
	public void incluir(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista(){		
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	
}
