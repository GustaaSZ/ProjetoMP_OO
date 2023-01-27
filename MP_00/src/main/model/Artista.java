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

    // Atributo estiloMusical, que diferencia a classe filha da classe pai
    private String estiloMusical;

    // Array de musicas no artista
    private final ArrayList<Musica> musicas;

    //Array com todos os artistas cadastrados
    public static final ArrayList<Artista> artistasCadastrados = new ArrayList<>();

    /**
     * Método Construtor da classe Artista.
     * @param nome String.
     * @param estiloMusical String.
     */
    public Artista(String nome, String estiloMusical) {
        super(nome);
        this.estiloMusical = estiloMusical;
        this.musicas = new ArrayList<>();
        artistasCadastrados.add(this);
    }

    // Métodos gets e sets
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public String getEstiloMusical(){
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical){
        this.estiloMusical = estiloMusical;
    }

    // ToString da classe
    @Override
    public String toString() {
        return "O artista " + this.getNome() + ", tem como estilo musical o "+ this.getEstiloMusical()+".";
    }

}
