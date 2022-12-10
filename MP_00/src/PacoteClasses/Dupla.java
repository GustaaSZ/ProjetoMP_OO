package PacoteClasses;

import java.util.ArrayList;

public class Dupla extends Pessoa {

	// Atributos
	private String nomeDupla;
	private int idadeDupla;
	private String nacionalidadeDupla;
	private String estiloMusicalDupla;
	
	// Como uma Dupla pode ter nenhuma ou várias musicas, pegamos uma lista de musicas e colocamos na classe Artista
	private ArrayList<Musica> musicas;
	
	// Encapsulamento dos Atributos
	
	public String getNomeDupla() {
		return nomeDupla;
	}
	
	public void setNomeDupla(String nomeDupla) {
		this.nomeDupla = nomeDupla;
	}
	
	public int getIdadeDupla() {
		return idadeDupla;
	}
	
	public void setIdadeDupla(int idadeDupla) {
		this.idadeDupla = idadeDupla;
	}
	
	public String getNacionalidadeDupla() {
		return nacionalidadeDupla;
	}
	
	public void setNacionalidadeDupla(String nacionalidadeDupla) {
		this.nacionalidadeDupla = nacionalidadeDupla;
	}
	
	public String getEstiloMusicalDupla() {
		return estiloMusicalDupla;
	}
	
	public void setEstiloMusicalDupla(String estiloMusicalDupla) {
		this.estiloMusicalDupla = estiloMusicalDupla;
	}
	
	
	/* 
	 * Criando o método construtor da classe Artista, assim, quando um artista for criado, criamos também uma lista de musicas :
	*/
	public Dupla() {
		musicas = new ArrayList<Musica>();
	}
	
	//------------------------- Manipulando a lista de musicas na classe Dupla: -----------------------------
	
		//1º
		public void adicionarMusica(Musica musica) {
			// add musica
			musicas.add(musica);
		}
		
		//2º
		public int quantidadeMusicas() {
			// Retorna a quantidade de musicas
			return musicas.size();
		}
		
		//3º
		public void excluirMusica(Musica musica) {
			// exclui musica
			musicas.remove(musica);
		}
		
		//4º
		public Musica getMusica(int posicao) {
			// Retorna as musicas de cada posição
			return musicas.get(posicao);
		}
	
	
}
