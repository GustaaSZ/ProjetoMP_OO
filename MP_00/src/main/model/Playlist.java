package main.model;

import java.util.ArrayList;

public class Playlist {

	private String nome;
	private String descricao;
	private final ArrayList<Musica> musicas;
	
	//Array com todas as playlists cadastradas
	public static final ArrayList<Playlist> playlistsCadastradas = new ArrayList<>();
	
	public Playlist(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.musicas = new ArrayList<>();

		playlistsCadastradas.add(this);
	}

	public Playlist(Ouvinte ouvinte, String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.musicas = new ArrayList<>();

		playlistsCadastradas.add(this);
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

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}


	@Override
	public String toString() {
		return "Playlist " + this.nome + " possui " + musicas.size() + " musicas cadastradas!";
	}
	
}
