package model;

import java.util.ArrayList;

public class Playlist {

	private String nome;
	private String descricao;
	private final ArrayList<Musica> musicas;

	//Array com todas as playlists cadastradas
	public static ArrayList<Playlist> playlistsCadastradas = new ArrayList<>();

//	Mudança feita aq
	// Adicionando uma lista de ouvintes

	// Playlist pode ter vários ouvintes, com isso, pegamos uma lista de 
	private final ArrayList<Ouvinte> ouvintes;
	
	// Mudança aq, eu havia colocado no construtor o array de ouvintes, porém havia dado probela em outra classe. (ArrayList<Ouvinte> ouvintes)
	public Playlist(String nome, String descricao) {
		this.nome = nome;
//		Mudança feita aq
		this.ouvintes = new ArrayList<>();
		this.descricao = descricao;
		this.musicas = new ArrayList<>();

		playlistsCadastradas.add(this);
	}

	// Encapsulando o Array de ouvintes
	public ArrayList<Ouvinte> getOuvintes() {
        return ouvintes;
    }
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Playlist " + this.nome + " possui: " + musicas.size() + " musicas cadastradas!";
	}

	public void adicionarMusica(Musica musica) {
		this.musicas.add(musica);
	}

	public void removerMusica(Musica musica) {
		this.musicas.remove(musica);
	}

	public void listarMusicas() {
		System.out.println("--------------------------------------------------");
		System.out.println("Musicas da playlist " + this.nome + ":");
		for (Musica value: musicas) {
			System.out.println(value);
		}
		System.out.println("--------------------------------------------------");
	}
	
}
