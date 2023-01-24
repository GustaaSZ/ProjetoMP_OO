package main.model;

import java.util.ArrayList;

public class Ouvinte extends Pessoa {

    // Atributo musicaFavorita, que diferencia a classe filha da classe pai
    private String musicaFavorita;

    private final ArrayList<Playlist> playlists;

    public static final ArrayList<Ouvinte> ouvintesCadastrados = new ArrayList<>();

    public Ouvinte(String nome, String musicaFavorita) {
        super(nome);
        this.musicaFavorita = musicaFavorita;
        this.playlists = new ArrayList<>();
        ouvintesCadastrados.add(this); 
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    // Encapsulamento dos Atributo MusicaFavorita
    public String getMusicaFavorita(){
        return musicaFavorita;
    }

    public void setMusicaFavorita(String musicaFavorita){
        this.musicaFavorita = musicaFavorita;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}

