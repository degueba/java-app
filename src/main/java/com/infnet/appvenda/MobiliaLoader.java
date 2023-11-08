package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.service.MobiliaService;

@Order(3)
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
			
			campos = linha.split(";");
			
			Mobilia mobilia = new Mobilia();

			mobilia.setCodigo(Integer.valueOf(campos[0]));
			mobilia.setDescricao(campos[1]);
			mobilia.setCategoria(campos[2]);
			mobilia.setCor(campos[3]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			mobilia.setVendedor(vendedor);
			
			mobiliaService.incluir(mobilia);
			
			linha = leitura.readLine();
		}

		for(Mobilia mobilia: mobiliaService.obterLista()) {
			System.out.println("[Alimentício] " + mobilia);			
		}

		leitura.close();
	}
}