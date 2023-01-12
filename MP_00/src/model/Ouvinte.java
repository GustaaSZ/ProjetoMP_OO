package model;

import java.util.ArrayList;

public class Ouvinte extends Pessoa {

    private Musica musicaFavorita;
    private final ArrayList<Playlist> playlists;
    
    public static ArrayList<Ouvinte> ouvintesCadastrados = new ArrayList<>();

    public Ouvinte(String nome) {
        super(nome);
        this.playlists = new ArrayList<>();
        
        ouvintesCadastrados.add(this);
    }

    //------------------- MUDANÇA NESSE PARTE (ADICIONEI ESSE 2º CONSTRUTOR)------------------
//    public Ouvinte(Playlist playlist, String nome, Musica musicaFavorita) {
//        super(nome);
//        this.playlists = new ArrayList<>();
//        
//        ouvintesCadastrados.add(this);
//        
//        playlists.add(playlist);
//        playlist.getOuvintes().add(this);
//    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public Musica getMusicaFavorita() {
        return musicaFavorita;
    }

    public void setMusicaFavorita(Musica musicaFavorita) {
        this.musicaFavorita = musicaFavorita;
    }

	@Override
	public String toString() {
		return this.getNome();
	}
    
    
}

