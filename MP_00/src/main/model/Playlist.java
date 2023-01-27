package main.model;

import java.util.ArrayList;

/**
 * Classe que representa uma playlist.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Playlist {

    // Atributos
    private String nome;
    private String descricao;

    // Array de musicas
    private final ArrayList<Musica> musicas;

    //Array com todas as playlists cadastradas
    public static final ArrayList<Playlist> playlistsCadastradas = new ArrayList<>();

    /**
     * Construtor da classe Playlist.
     * @param nome String
     * @param descricao String.
     */
    public Playlist(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.musicas = new ArrayList<>();

        playlistsCadastradas.add(this);
    }


    /**
     * Construtor da classe playlist. Agora, passando como parâmetro, um ouvinte instânciado.
     * @param ouvinte Ouvinte.
     * @param nome String.
     * @param descricao String.
     */
    public Playlist(Ouvinte ouvinte, String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.musicas = new ArrayList<>();

        playlistsCadastradas.add(this);
    }

    // Métodos gets e sets
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

    // Método toString da classe
    @Override
    public String toString() {
        return this.nome + " possui " + musicas.size() + " musicas cadastradas!";
    }

}
