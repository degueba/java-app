package com.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.appvenda.clients.IEnderecoClient;
import com.infnet.appvenda.model.domain.Endereco;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.repository.VendedorRepository;


@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	
	public void incluir(Vendedor vendedor) {
		String cep = vendedor.getEndereco().getCep();
		Endereco endereco = enderecoClient.buscarCep(cep);
		vendedor.setEndereco(endereco);
		
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista(){		
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	
	
	public long obterQtde() {
		return vendedorRepository.count();
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
}
