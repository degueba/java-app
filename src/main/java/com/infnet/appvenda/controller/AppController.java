package com.infnet.appvenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.infnet.appvenda.model.service.VendasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.infnet.appvenda.model.service.GameService;
import com.infnet.appvenda.model.service.MobiliaService;
import com.infnet.appvenda.model.service.ProdutoService;
import com.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private GameService gameService;

	@Autowired
	private MobiliaService mobiliaService;
	
	@Autowired
	private VendasService vendasService;
	
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("informacoes", vendasService.obterInformacao());
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeGame", gameService.obterQtde());
		model.addAttribute("qtdeMobilia", mobiliaService.obterQtde());
		
		return "home";
	}
	

	
	@GetMapping(value = "/game/lista")
	public String obterGameLista(Model model) {
		model.addAttribute("titulo", "Games:");
		model.addAttribute("listagem", gameService.obterLista());
		
		return showHome(model);
	}
	
}
