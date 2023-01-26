package main.controller;

import main.model.Artista;
import main.model.Musica;

import static main.model.Musica.musicasCadastradas;
import static main.util.Conversor.stringToDate;

/**
 * Classe com métodos para manipulação de músicas.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MusicaController {

    private final Musica musica;

    public MusicaController(Musica musica) {
        this.musica = musica;
    }

    /**
     * Método para adicionar um artista a uma música.
     * @param artista artista que será adicionado.
     * @return retorna true se o artista for adicionado com sucesso.
     */
    public boolean adicionarArtista(Artista artista) {
        if (musica.getArtistas().contains(artista)) {
            return false;
        }
        musica.getArtistas().add(artista);
        artista.getMusicas().add(musica);
        return true;
    }

    /**
     * Método para remover um artista de uma música.
     * @param artista artista que será removido.
     * @return retorna true se o artista for removido com sucesso.
     */
    public boolean removerArtista(Artista artista) {
        if (!musica.getArtistas().contains(artista)) {
            return false;
        }
        if (musica.getArtistas().size() == 1) {
            return false;
        }
        musica.getArtistas().remove(artista);
        artista.getMusicas().remove(musica);
        return true;
    }


    /**
     * Método para atualizar os dados da música.
     * @param nome nome que será atribuído a música.
     * @param genero genero que será atribuído a música.
     * @param lancamento data de lançamento que será atribuída a música.
     * @param letra letra que será atribuída a música.
     */
    public void atualizarMusica(String nome, String genero, String lancamento, String letra) {
        musica.setNome(nome);
        musica.setGenero(genero);
        musica.setLancamento(stringToDate(lancamento));
        musica.setLetra(letra);
    }

    /**
     * Método para cadastrar uma música.
     * @param artista artista que será atribuído a música.
     * @param nome nome que será atribuído a música.
     * @param letra letra que será atribuída a música.
     * @param genero genero que será atribuído a música.
     * @param lancamento data de lançamento que será atribuída a música.
     * @return retorna true se a música for cadastrada com sucesso.
     */
    public static boolean cadastrarMusica(Artista artista, String nome, String letra, String genero, String lancamento) {
        if (!musicaExiste(buscarMusicaPorNome(nome))) {
            new Musica(artista, nome.trim(), letra.trim(), genero.trim(), stringToDate(lancamento));
            return true;
        }
        return false;
    }

    /**
     * Método para remover uma música cadastrada.
     * @param musica música que será removida.
     * @return retorna true se a música for removida com sucesso.
     */
    public static boolean removerMusica(Musica musica) {
        if (!musicaExiste(musica)) {
            return false;
        }
        musicasCadastradas.remove(musica);
        return true;
    }

    /**
     * Método para buscar uma música por nome.
     * @param nome nome da música que será buscada.
     * @return retorna a música se ela for encontrada.
     */
    public static Musica buscarMusicaPorNome(String nome) {
        return musicasCadastradas.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    /**
     * Método que busca uma música pelo seu index no ArrayList de músicas cadastradas.
     * @param index da música que será buscada.
     * @return retorna a música se ela for encontrada.
     */
    public static Musica musicaPorIndex(int index) {
        return musicasCadastradas.get(index);
    }

    /**
     * Método para verificar a quantidade de músicas cadastradas.
     * @return retorna a quantidade de músicas cadastradas.
     */
    public static int quantidadeMusicasCadastradas() {
        return musicasCadastradas.size();
    }

    /**
     * Método para verificar se o ArrayList de músicas cadastradas está vazio.
     * @return retorna true se o ArrayList estiver vazio.
     */
    public static boolean isMusicasEmpty() {
        return musicasCadastradas.isEmpty();
    }

    /**
     * Método que converte o ArrayList de músicas cadastradas em um vetor com seus respectivos nomes.
     * @return retorna um vetor com os nomes das músicas cadastradas.
     */
    public static String[] arrayMusicasCadastradas() {
        String[] array = new String[musicasCadastradas.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = musicasCadastradas.get(i).getNome();
        }
        return array;
    }

    /**
     * Método que converte o Arraylist de artistas de uma música em um vetor de artistas.
     * @param mus música que será convertida.
     * @return retorna um vetor com os artistas da música.
     */
    public static String[] arrayArtistasNaMusica(Musica mus) {
        String[] array = new String[mus.getArtistas().size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = mus.getArtistas().get(i).getNome();
        }
        return array;
    }

    /**
     * Método que verifica se uma música existe.
     * @param musica música que será verificada.
     * @return retorna true se a música existir.
     */
    private static Boolean musicaExiste(Musica musica) {
        return musicasCadastradas.contains(musica);
    }
}

