package main.model;

import java.util.ArrayList;

/**
 * Classe que representa um artista e herda de Pessoa.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Artista extends Pessoa {
    private final ArrayList<Musica> musicas;

    //Array com todos os artistas cadastrados
    public static final ArrayList<Artista> artistasCadastrados = new ArrayList<>();

    public Artista(String nome) {
        super(nome);
        this.musicas = new ArrayList<>();
        artistasCadastrados.add(this);
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
