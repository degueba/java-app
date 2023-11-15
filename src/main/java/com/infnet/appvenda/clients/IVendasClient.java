package com.infnet.appvenda.clients;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081/api/informacoes", name = "informacaoClient")
public interface IVendasClient {

	@GetMapping(value = "/informacoes")
	public List<String> obterInformacao();	
}