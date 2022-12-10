package PacoteClasses;

import java.util.ArrayList;

public class Playlist {

	// Atributo
	private String nomePlaylist;

	// Como uma Playlits pode ter no mínimo uma ou várias musicas, pegamos uma lista de musicas e colocamos na classe Playlist
	private ArrayList<Musica> musicas;
	
	// Encapsulamento do atributo
	
	public String getNomePlaylist() {
		return nomePlaylist;
	}

	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}
	
	/* 
	 * Criando o método construtor da classe Playlits, assim, quando uma playlist for criada, criamos também uma lista de musicas :
	*/
	public Playlist() {
		musicas = new ArrayList<Musica>();
	}
	
	//------------------------- Manipulando a lista de musicas na classe Playlist: -----------------------------
	
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
