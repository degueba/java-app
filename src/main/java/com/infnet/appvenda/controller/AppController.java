package com.infnet.appvenda.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.infnet.appvenda.model.service.GameService;
import com.infnet.appvenda.model.service.MobiliaService;
import com.infnet.appvenda.model.service.ProdutoService;
import com.infnet.appvenda.model.service.VendedorService;

@Controller
@Transactional
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private GameService gameService;

	@Autowired
	private MobiliaService mobiliaService;
	
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeGames", gameService.obterQtde());
		model.addAttribute("qtdeMobilia", mobiliaService.obterQtde());
		
		return "home";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterVendedorLista(Model model) {
		model.addAttribute("listagem", vendedorService.obterLista());
		
		return "redirect:/";
	}
	
	
	@GetMapping(value = "/produto/lista")
	public String obterProdutoLista(Model model) {
		model.addAttribute("listagem", produtoService.obterLista());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/game/lista")
	public String obterGameLista(Model model) {
		model.addAttribute("listagem", gameService.obterLista());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/mobilia/lista")
	public String obterMobiliaLista(Model model) {
		model.addAttribute("listagem", mobiliaService.obterLista());
		
		return "redirect:/";
	}
}
