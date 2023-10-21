package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Game;
import com.infnet.appvenda.model.domain.Game.GameMode;
import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.domain.Produto;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.service.ProdutoService;
import com.infnet.appvenda.model.service.VendedorService;

@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		
		while(linha != null) {
			Mobilia mobilia = new Mobilia();
			Game game = new Game();
			
			String[] produtos = linha.split(";");
			
			campos = linha.split(";"); 
			
			switch(campos[6]) {
				case "Mobilia":
					mobilia.setCodigo(Integer.parseInt(produtos[0]));
					mobilia.setNome(campos[0]);
					mobilia.setDescricao("Este produto e " + produtos[1]);
					mobilia.setEstoque(Integer.parseInt(produtos[5]) == 1 ? true : false);
					mobilia.setCor(campos[3]);
					mobilia.setPreco(Float.parseFloat(produtos[4]));
					produtoService.incluir(mobilia);
					break;
				case "Game":
					game.setCodigo(Integer.parseInt(produtos[0]));
					game.setNome(produtos[1]);
					game.setDescricao("Este produto e " + produtos[1]);
					game.setEstoque(Integer.parseInt(produtos[5]) == 1 ? true : false);
					game.setCategoria(produtos[2]);
					game.setGameMode(GameMode.valueOf(produtos[3]));
					game.setPreco(Float.parseFloat(produtos[4]));
					
					produtoService.incluir(game);
			}
			
			linha = leitura.readLine();
		}
		
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto]: " + produto);
		}
		
		
		
		leitura.close();
	}

}
