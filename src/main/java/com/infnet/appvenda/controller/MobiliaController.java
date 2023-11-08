package com.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infnet.appvenda.model.service.MobiliaService;

@Controller
public class MobiliaController {
	@Autowired
	private AppController appController;
	
	@Autowired
	private MobiliaService mobiliaService;
	
	@GetMapping(value = "mobilia/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		
		mobiliaService.excluir(id);
		
		return null;
	}
	
	@GetMapping(value = "/mobilia/lista")
	public String obterLista(Model model) {
		model.addAttribute("rota", "mobilia");
		model.addAttribute("titulo", "Mobilia:");
		model.addAttribute("listagem", mobiliaService.obterLista());
		
		return appController.showHome(model);
	}
}
