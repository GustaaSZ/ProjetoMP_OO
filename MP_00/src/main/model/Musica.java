package main.model;

import java.util.ArrayList;
import java.util.Date;

import static main.util.Conversor.arrayListArtistaToString;
import static main.util.Conversor.dateToString;

/**
 * Classe que representa uma música.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Musica {

    // Array de artistas na Musica
    private final ArrayList<Artista> artistas;

    // Atributos
    private String nome;
    private String genero;
    private Date lancamento;
    private String letra;

    //Array com todas as músicas cadastradas.
    public static final ArrayList<Musica> musicasCadastradas = new ArrayList<>();

     /**
     * Método Construtor da classe Musica.
     * @param nome String.
     * @param letra String
     * @param genero String.
     * @param lacamento Date.
     */
    public Musica(String nome, String letra, String genero, Date lancamento) {
        this.artistas = new ArrayList<>();
        this.nome = nome;
        this.letra = letra;
        this.genero = genero;
        this.lancamento = lancamento;

        musicasCadastradas.add(this);
    }

    /**
     * Método Construtor da classe Musica. Agora, passando como parâmetro uma artista instânciado.
     * @param artista Artista.
     * @param nome String.
     * @param letra String
     * @param genero String.
     * @param lacamento Date.
     */
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

    // Métodos gets e sets
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

    // ToString da classe
    @Override
    public String toString() {
        return artistas.size() == 1
                ?
                this.nome + " foi lancada em " + dateToString(lancamento)
                        + ", do genero " + genero + " e foi feita pelo artista " + artistas.get(0).getNome() + ","+ " Que tem como Estilo Musical o/a " + artistas.get(0).getEstiloMusical() +"."
                :
                this.nome + " foi lancada em " + dateToString(lancamento) +
                        ", do genero " + genero + " e foi feita pelos artistas: "
                        + arrayListArtistaToString(artistas);
    }
}
