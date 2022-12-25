package model;

public class LetraMusica {
	
	private String letra;

	public LetraMusica(String letra) {
		this.letra = letra;
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
