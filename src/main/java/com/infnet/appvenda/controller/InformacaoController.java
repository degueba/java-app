package com.infnet.appvenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.infnet.appvenda.model.domain.Informacao;
import com.infnet.appvenda.model.service.InformacaoService;

@Controller
public class InformacaoController {
	
	@Autowired
	private InformacaoService informacaoService;
	
	@Autowired
	
	
	@GetMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
		
		Informacao result = informacaoService.incluir(informacao);
		System.out.println(informacao);	
		
		return "redirect:/";
	}
	
	
}
