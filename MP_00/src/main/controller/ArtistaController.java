package main.controller;

import main.model.Artista;
import main.model.Musica;

import static main.model.Artista.artistasCadastrados;
// import static main.model.Musica.musicasCadastradas;

/**
 * Classe com métodos para manipulação de artistas.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class ArtistaController {

    // Instânciando um artista. Essa intânciação permite 
    // que o o valor de artista seja atribuido uma unica vez nessa classe.
    private final Artista artista;

    public ArtistaController(Artista artista) {
        this.artista = artista;
    }

    /**
     * Método para editar um artista.
     * @param nome do artista.
     * @param estiloMusical estilo musical do artista.
     */
    public void editarArtista(String nome, String estiloMusical) {
        artista.setNome(nome);
        artista.setEstiloMusical(estiloMusical);
    }

    // ---------------- METODOS ESTATICOS ----------------

    /**
     * Método para cadastrar um artista.
     * @param nome do artista.
     * @param estiloMusical, estilo musical do artista.
     * Retorna true se o artista for cadastrado com sucesso.
     * @return boolean
     */
    public static boolean cadastrarArtista(String nome, String estiloMusical) {
        if (!artistaExiste(buscarArtistaPorNome(nome))) {
            new Artista(nome.trim(), estiloMusical.trim());
            return true;
        }
        return false;
    }

    /**
     * Método para remover um artista cadastrado.
     * @param artista artista que será removido.
     * Retorna true se o artista for removido com sucesso.
     * @return boolean
     */
    public static boolean removerArtistaCadastrado(Artista artista) {
        if (!artistaExiste(artista)) {
            return false;
        }
        if (artista.getMusicas().isEmpty()) {
            artistasCadastrados.remove(artista);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para buscar um artista por nome.
     * @param nome nome do artista que será buscado.
     * @return retorna o artista se ele existir.
     */
    public static Artista buscarArtistaPorNome(String nome) {
        return artistasCadastrados.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    /**
     * Método para procurar um artista pelo seu index no ArrayList de artistas cadastrados.
     * @param index index do artista.
     * @return retorna o artista.
     */
    public static Artista artistaPorIndex(int index) {
        return artistasCadastrados.get(index);
    }

    /**
     * Método para verificar a quantidade de artistas cadastrados.
     * @return retorna a quantidade de artistas cadastrados.
     */
    public static int quantidadeArtistasCadastrados() {
        return artistasCadastrados.size();
    }

    /**
     * Método para verificar se existe algum artista cadastrado.
     * @return retorna true se não existir nenhum artista cadastrado.
     */
    public static boolean isArtistasEmpty() {
        return artistasCadastrados.isEmpty();
    }

    /**
     * Método que converte o ArrayList de artistas cadastrados em um vetor de strings com os nomes dos artistas.
     * @return retorna um vetor de artistas.
     */
    public static String[] arrayArtistasCadastrados() {
    	String[] array = new String[artistasCadastrados.size()];
    	for (int i = 0; i < array.length; i++) {
            array[i] = artistasCadastrados.get(i).getNome();
        }
        return array;
    }

    /**
     * Método que converte o ArrayList de músicas de um artista em um vetor de músicas.
     * @param artista artista que deseja converter o ArrayList de músicas.
     * @return retorna o vetor de músicas.
     */
    public static Musica[] arrayMusicasDoArtista(Artista artista) {
        return artista.getMusicas().toArray(new Musica[0]);
    }

    /**
     * Método para verificar se um artista existe.
     * @param artista artista que será verificado.
     * @return retorna true se o artista existir.
     */
    private static Boolean artistaExiste(Artista artista) {
        return artistasCadastrados.contains(artista);
    }
}
