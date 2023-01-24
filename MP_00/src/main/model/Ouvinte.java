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
    private final ArrayList<Playlist> playlists;

    public static final ArrayList<Ouvinte> ouvintesCadastrados = new ArrayList<>();

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

