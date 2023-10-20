package com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.infnet.appvenda.model.domain.Produto;

@Service
public class ProdutoService {
	private Map<String, Produto> mapaProduto = new HashMap<String, Produto>();
	
	public void incluir(Produto produto) {
		mapaProduto.put(produto.getDescricao(), produto);
	}
	
	public Collection<Produto> obterLista(){
		return mapaProduto.values();
	}
	
}
