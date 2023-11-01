package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Game;
import com.infnet.appvenda.model.domain.Game.GameMode;
import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.domain.Produto;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.service.ProdutoService;

@Order(2)
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
		
		Vendedor vendedor = new Vendedor();
		
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
					mobilia.setEstoque(Boolean.valueOf(produtos[5]));
					mobilia.setCor(campos[3]);
					mobilia.setPreco(Float.parseFloat(produtos[4]));
					
					vendedor.setId(Integer.valueOf(produtos[7]));
					mobilia.setVendedor(vendedor);
					
					produtoService.incluir(mobilia);
					break;
				case "Game":
					game.setCodigo(Integer.parseInt(produtos[0]));
					game.setNome(produtos[1]);
					game.setDescricao("Este produto e " + produtos[1]);
					game.setEstoque(Boolean.valueOf(produtos[5]));
					game.setCategoria(produtos[2]);
					game.setGameMode(GameMode.valueOf(produtos[3]));
					game.setPreco(Float.parseFloat(produtos[4]));
					
					vendedor.setId(Integer.valueOf(produtos[7]));
					game.setVendedor(vendedor);
					
					produtoService.incluir(game);
			}
			
			linha = leitura.readLine();
		}
		
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto]: " + produto);
		}
		
		
		System.out.println("[Produto do Vendedor  "  + vendedor.getId());
		for(Produto produto: produtoService.obterLista(vendedor.getId())) {
			System.out.println("[Produto]: " + produto);
		}
		
		
		for(Produto produto: produtoService.obterLista(vendedor)) {
			System.out.println("[Produto]: " + produto);
		}
		
		
		leitura.close();
	}

}
