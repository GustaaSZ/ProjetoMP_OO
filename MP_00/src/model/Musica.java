package model;

import java.util.ArrayList;
import java.util.Date;

import util.Conversor;

public class Musica {

    private ArrayList<Artista> artistas;
    private String nome;
    private String genero;
    private Date lancamento;
    private String letra;

    //Array com todas as músicas cadastradas.
    public static ArrayList<Musica> musicasCadastradas = new ArrayList<>();

    public Musica(String nome, String letra, String genero, Date lancamento) {
        this.artistas = new ArrayList<>();
        this.nome = nome;
        this.letra = letra;
        this.genero = genero;
        this.lancamento = lancamento;

        musicasCadastradas.add(this);
    }
    
    public Musica(Artista artista, String nome, String letra, String genero, Date lancamento) {
        this.artistas = new ArrayList<>();
        this.nome = nome;
        this.letra = letra;
        this.genero = genero;
        this.lancamento = lancamento;

        musicasCadastradas.add(this);

        artistas.add(artista);
        artista.getMusicas().add(this);
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
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
