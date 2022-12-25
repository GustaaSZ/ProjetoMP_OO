package model;

import java.util.ArrayList;

public class Artista extends Pessoa {

    private final ArrayList<Musica> musicas;

    //Array com todos os artistas cadastrados
    public static ArrayList<Artista> artistasCadastrados = new ArrayList<>();

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
        return "Artista " + this.getNome() + " possui: " + musicas.size() + " musicas cadastradas!";
    }

}
