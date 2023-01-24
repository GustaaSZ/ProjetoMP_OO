package main.model;

import java.util.ArrayList;

/**
 * Classe que representa um ouvinte e herda de Pessoa.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Ouvinte extends Pessoa {

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

    public String getMusicaFavorita(){
        return musicaFavorita;
    }

    public void setMusicaFavorita(String musicaFavorita){
        this.musicaFavorita = musicaFavorita;
    }

    @Override
    public String toString() {
        return "O ouvinte " + this.getNome() + ", tem como música favorita a música " + this.getMusicaFavorita() + ".";
    }

}

