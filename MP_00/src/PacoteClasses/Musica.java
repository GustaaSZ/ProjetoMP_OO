package PacoteClasses;

import java.util.ArrayList;
import java.util.Date;

public class Musica {

	// Atributos
	
	private String nomeMusica;
	private String generoMusica;
	private String letra;
	private String lancamento;
	
	// Como uma Musica pode ter nenhuma ou vários artistas, pegamos uma lista de artistas e colocamos na classe Musica
	private ArrayList<Artista> artistas;
	
	// Como uma Musica pode ter nenhuma ou várias duplas, pegamos uma lista de duplas e colocamos na classe Musica
	private ArrayList<Dupla> duplas;
	
	// Como uma Musica pode ter nenhuma ou várias playlists, pegamos uma lista de playlists e colocamos na classe Musica
	private ArrayList<Playlist> playlists;
	
	// Encapsulamento dos Atributos
	
	public String getNomeMusica() {
		return nomeMusica;
	}
	
	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	
	public String getGeneroMusica() {
		return generoMusica;
	}
	
	public void setGeneroMusica(String generoMusica) {
		this.generoMusica = generoMusica;
	}
	
	public String getLetra() {
		return letra;
	}
	
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public String getLancamento() {
		return lancamento;
	}
	
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	
	/* 
	 * Criando o método construtor da classe Artista, assim, quando uma musica for 
	 * criada, criamos também uma lista de artistas, duplas e playlists :
	*/
	public Musica() {
		
		artistas = new ArrayList<Artista>();
		duplas = new ArrayList<Dupla>();
		playlists = new ArrayList<Playlist>();
	}
	
	
	
	//------------------------- Manipulando a lista de artistas na classe Musica: -----------------------------
	
		//1º
		public void adicionarArtista(Artista artista) {
			// add artista
			artistas.add(artista);
		}
		
		//2º
		public int quantidadeArtistas() {
			// Retorna a quantidade de artistas
			return artistas.size();
		}
		
		//3º
		public void excluirArtista(Artista artista) {
			// exclui artista
			artistas.remove(artista);
		}
		
		//4º
		public Artista getArtista(int posicao) {
			// Retorna os artistas de cada posição
			return artistas.get(posicao);
		}
	
		//------------------------- Manipulando a lista de duplas na classe Musica: -----------------------------
		
		//1º
		public void adicionarDupla(Dupla dupla) {
			// add artista
			duplas.add(dupla);
		}
		
		//2º
		public int quantidadeDuplas() {
			// Retorna a quantidade de artistas
			return duplas.size();
		}
		
		//3º
		public void excluirDupla(Dupla dupla) {
			// exclui artista
			duplas.remove(dupla);
		}
		
		//4º
		public Dupla getDupla(int posicao) {
			// Retorna os artistas de cada posição
			return duplas.get(posicao);
		}
		
		//------------------------- Manipulando a lista de playlists na classe Musica: -----------------------------
		
		//1º
		public void adicionarPlaylist(Playlist playlist) {
			// add playlist
			playlists.add(playlist);
		}
		
		//2º
		public int quantidadePlaylists() {
			// Retorna a quantidade de playlists
			return playlists.size();
		}
		
		//3º
		public void excluirPlaylist(Playlist playlist) {
			// exclui playlist
			playlists.remove(playlist);
		}
		
		//4º
		public Playlist getPlaylist(int posicao) {
			// Retorna as playlists de cada posição
			return playlists.get(posicao);
		}
	
}
