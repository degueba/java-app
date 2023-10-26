package com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.infnet.appvenda.model.domain.Game;


@Service
public class GameService {
	private Map<String, Game> mapaGame = new HashMap<String, Game>();
	
	public void incluir(Game game) {
		mapaGame.put(game.getNome(), game);
	}
	
	public Collection<Game> obterLista(){
		return mapaGame.values();
	}
	
}
