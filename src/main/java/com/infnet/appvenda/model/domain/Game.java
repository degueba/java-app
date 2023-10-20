package com.infnet.appvenda.model.domain;

enum GameMode {
	One, 
	Two
}

public class Game extends Produto {
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
