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

    // Atributo
    private String musicaFavorita;

    // Array de playlists
    private final ArrayList<Playlist> playlists;

    // Array com todos ouvintes cadastrados
    public static final ArrayList<Ouvinte> ouvintesCadastrados = new ArrayList<>();

    /**
     * Método Construtor da classe Ouvinte.
     * @param nome String.
     * @param musicaFavorita String
     */
    public Ouvinte(String nome, String musicaFavorita) {
        // Aciona o construtor da classe Pessoa
        super(nome);
        this.musicaFavorita = musicaFavorita;
        this.playlists = new ArrayList<>();
        ouvintesCadastrados.add(this); 
    }

    // Métodos gets e sets
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public String getMusicaFavorita(){
        return musicaFavorita;
    }

    public void setMusicaFavorita(String musicaFavorita){
        this.musicaFavorita = musicaFavorita;
    }

    // ToString da classe
    @Override
    public String toString() {
        return "O ouvinte " + this.getNome() + ", tem como música favorita a música " + this.getMusicaFavorita() + ".";
    }

}

