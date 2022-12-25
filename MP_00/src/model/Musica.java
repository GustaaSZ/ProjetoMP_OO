package model;

import util.Conversor;

import java.util.ArrayList;
import java.util.Date;

public class Musica {

    private final ArrayList<Artista> artistas;
    private String nome;
    private String genero;
    private Date lancamento;
    private LetraMusica letraMusica;

    //Array com todas as músicas cadastradas.
    public static ArrayList<Musica> musicasCadastradas = new ArrayList<>();

    public Musica(ArrayList<Artista> artistas, String nomeDaMusica, LetraMusica letraMusica, String genero, Date lancamento) {
        this.artistas = artistas;
        this.nome = nomeDaMusica;
        this.letraMusica = letraMusica;
        this.genero = genero;
        this.lancamento = lancamento;

        musicasCadastradas.add(this);

        for (Artista artista : artistas) {
            artista.getMusicas().add(this);
        }
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public LetraMusica getLetraMusica() {
        return letraMusica;
    }

    @Override
    public String toString() {
        return artistas.size() == 1
                ?
                "A musica " + nome + " foi lancada em " + Conversor.dateToString(lancamento)
                        + ", do genero " + genero + " e foi feita pelo artista " + artistas.get(0).getNome() + "."
                :
                "A musica " + nome + " foi lancada em " + Conversor.dateToString(lancamento) +
                        ", do genero " + genero + " e foi feita pelos artistas: "
                        + Conversor.arrayListArtistaToString(artistas) + ".";
    }

}
