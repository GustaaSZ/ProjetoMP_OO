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

