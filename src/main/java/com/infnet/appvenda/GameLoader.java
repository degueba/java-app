package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Game;
import com.infnet.appvenda.model.domain.Game.GameMode;
import com.infnet.appvenda.model.service.GameService;

@Component
public class GameLoader implements ApplicationRunner {
	
	@Autowired
	private GameService gameService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/game.txt");
		BufferedReader leitura = new BufferedReader(file);
		
	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		
		while(linha != null) {
			Game game = new Game();
			
			campos = linha.split(";"); 
			game.setNome(campos[0]);
			game.setCategoria(campos[2]);
			game.setPreco(Float.valueOf(campos[4]));
			game.setGameMode(GameMode.valueOf(campos[3]));
			
			gameService.incluir(game);
			
			linha = leitura.readLine();
		}
		
		
		for(Game game: gameService.obterLista()) {
			System.out.println("[Game]: " + game);
		}
		
		
		
		leitura.close();
	}

}
