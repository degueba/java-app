package com.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TGame")
public class Game extends Produto {
	public enum GameMode {
		One, 
		Two
	}
	
	private String nome;
	private String categoria;
	private Enum<GameMode> gameMode = GameMode.One; 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Enum<GameMode> getGameMode() {
		return gameMode;
	}
	public void setGameMode(Enum<GameMode> gameMode) {
		this.gameMode = gameMode;
	}
}
