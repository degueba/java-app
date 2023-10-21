package com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.infnet.appvenda.model.domain.Game;
import com.infnet.appvenda.model.domain.Mobilia;
import com.infnet.appvenda.model.domain.Vendedor;

@Service
public class MobiliaService {
	private Map<String, Mobilia> mapaMobilia = new HashMap<String, Mobilia>();
	
	public void incluir(Mobilia mobilia) {
		mapaMobilia.put(mobilia.getNome(), mobilia);
	}
	
	public Collection<Mobilia> obterLista(){
		return mapaMobilia.values();
	}
	
}
