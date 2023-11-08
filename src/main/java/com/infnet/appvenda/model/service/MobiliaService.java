package com.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.repository.MobiliaRepository;


@Service
public class MobiliaService {
	
	@Autowired
	private MobiliaRepository mobiliaRepository;
	
	
	public void incluir(Mobilia mobilia) {
		mobiliaRepository.save(mobilia);
	}
	
	public Collection<Mobilia> obterLista(){
		return (Collection<Mobilia>) mobiliaRepository.findAll();
	}

	public long obterQtde() {
		return mobiliaRepository.count();
	}
	
	public void excluir(Integer id) {
		mobiliaRepository.deleteById(id);
	}
}
