package main.model;

import java.util.ArrayList;

public class Ouvinte extends Pessoa {
    private final ArrayList<Playlist> playlists;
    
    public static ArrayList<Ouvinte> ouvintesCadastrados = new ArrayList<>();

    public Ouvinte(String nome) {
        super(nome);
        this.playlists = new ArrayList<>();
        ouvintesCadastrados.add(this);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

	@Override
	public String toString() {
		return this.getNome();
	}
    
}

