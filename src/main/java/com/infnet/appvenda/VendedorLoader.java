package com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.infnet.appvenda.model.domain.Endereco;
import com.infnet.appvenda.model.domain.Vendedor;
import com.infnet.appvenda.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vendedor.txt");
		BufferedReader leitura = new BufferedReader(file);
		
	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		
		while(linha != null) {
			Vendedor vendedor = new Vendedor();

			
			campos = linha.split(";"); 
			vendedor.setNome(campos[0]);
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
			vendedor.setEndereco(new Endereco(campos[3]));
			
			try {				
				vendedorService.incluir(vendedor);
			} catch(ConstraintViolationException e) {
				System.out.println("[Vendedor] " + vendedor);
				FileLogger.logException("[VENDEDOR] " + vendedor + " - " + e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		
		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("[Vendedor]: " + vendedor);
		}
		
		
		
		leitura.close();
	}

}
