package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.service.MobiliaService;

@Component
public class MobiliaLoader implements ApplicationRunner {
	
	@Autowired
	private MobiliaService mobiliaService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/mobilia.txt");
		BufferedReader leitura = new BufferedReader(file);
		
	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		
		while(linha != null) {
			Mobilia mobilia = new Mobilia();
			
			campos = linha.split(";"); 
			mobilia.setNome(campos[0]);
			mobilia.setCor(campos[3]);
			mobilia.setPreco(Float.valueOf(campos[4]));
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			mobilia.setVendedor(vendedor);
			
			mobiliaService.incluir(mobilia);
			
			linha = leitura.readLine();
		}
		
		
		for(Mobilia mobilia: mobiliaService.obterLista()) {
			System.out.println("[Mobilia]: " + mobilia);
		}
		
		
		
		leitura.close();
	}

}
