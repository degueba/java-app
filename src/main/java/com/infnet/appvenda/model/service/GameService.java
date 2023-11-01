package com.infnet.appvenda.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.appvenda.model.domain.Game;
import com.infnet.appvenda.model.repository.GameRepository;


@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	
	public void incluir(Game game) {
		gameRepository.save(game);
	}
	
	public Collection<Game> obterLista(){
		return (Collection<Game>) gameRepository.findAll();
	}
	
	public long obterQtde() {
		return gameRepository.count();
	}
}
