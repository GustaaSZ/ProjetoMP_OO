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

    private final ArrayList<Musica> musicas;

    //Array com todos os artistas cadastrados
    public static final ArrayList<Artista> artistasCadastrados = new ArrayList<>();

    public Artista(String nome, String estiloMusical) {
        super(nome);
        this.estiloMusical = estiloMusical;
        this.musicas = new ArrayList<>();
        artistasCadastrados.add(this);
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    // Encapsulamento do Atributo EstiloMusical
    public String getEstiloMusical(){
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical){
        this.estiloMusical = estiloMusical;
    }

    @Override
    public String toString() {
        return "O artista "+this.getNome()+", tem como estilo musical o "+this.getEstiloMusical()+".";
    }

}
