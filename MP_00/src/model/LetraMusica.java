package model;

import java.util.ArrayList;

public class LetraMusica {
	
	private String letra;
	
	public static ArrayList<LetraMusica> letrasCadastradas = new ArrayList<>();

	public LetraMusica(String letra) {
		this.letra = letra;
		
		letrasCadastradas.add(this);
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return letra;
	}
	
	
}
