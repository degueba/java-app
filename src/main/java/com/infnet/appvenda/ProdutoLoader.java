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
			
			String[] produtos = linha.split(";");
			
			campos = linha.split(";"); 
			mobilia.setCodigo(Integer.parseInt(produtos[0]));
			mobilia.setDescricao("Este produto e " + produtos[1]);
			mobilia.setEstoque(Integer.parseInt(produtos[5]) == 1 ? true : false);
			mobilia.setPreco(Float.parseFloat(produtos[4]));
			
			produtoService.incluir(mobilia);
			
			linha = leitura.readLine();
		}
		
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto]: " + produto);
		}
		
		
		
		leitura.close();
	}

}
