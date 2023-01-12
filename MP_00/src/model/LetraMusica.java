package model;

import java.util.ArrayList;

public class LetraMusica {

	// Atributo
	private String letra;
	
	public static ArrayList<LetraMusica> letrasCadastradas = new ArrayList<>();

	// Construtor
	public LetraMusica(String letra) {
		this.letra = letra;
		
		letrasCadastradas.add(this);
	}

	// Encapsulamento do Atributo
	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	// Método ToString
	@Override
	public String toString() {
		return letra;
	}
	
	
}
