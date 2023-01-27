package main.model;

/**
 * Classe abstrata que representa uma pessoa.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public abstract class Pessoa {
    // Essa classe é abstrata, pois não permite assim a criação de um objeto pessoa,
    // e sim de suas filhas (Artista e Ouvinte)

    // Atributo
    private String nome;

    // Métodos gets e sets
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
