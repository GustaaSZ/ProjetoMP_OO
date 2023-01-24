package main.controller;

import main.model.Musica;
import main.model.Playlist;

import static main.model.Playlist.playlistsCadastradas;

/**
 * Classe com métodos para manipulação das playlists.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class PlaylistController {

    private final Playlist playlist;

    public PlaylistController(Playlist playlist) {
        this.playlist = playlist;
    }


    /**
     * Método para adicionar uma musica a uma playlist.
     * @param Musica musica que será adicionada.
     * Retorna TRUE se a musica for adicionada, e FALSE se a musica já existir na playlist
     * @return boolean.
     */
    public boolean adicionarMusica(Musica musica) {
        if (playlist.getMusicas().contains(musica)) {
            return false;
        }
        playlist.getMusicas().add(musica);
        return true;
    }


    /**
     * Método para remover uma musica de uma playlist.
     * @param musica musica que será removida.
     * Retorna TRUE se a musica for removida e FALSE se ela não foi encontrada na playlist, sendo assim não pode ser removida
     * @return boolean.
     */
    public boolean removerMusica(Musica musica) {
        if (!playlist.getMusicas().contains(musica)) {
            return false;
        }
        playlist.getMusicas().remove(musica);
        return true;
    }


    /**
     * Método para atualizar os dados da playlist.
     * @param nome nome que será atribuído a playlist.
     * @param descricao que será atribuído a playlist.
     */
    public void atualizarPlaylist(String nome, String descricao) {
        playlist.setNome(nome);
        playlist.setDescricao(descricao);
    }


    /**
     * Método para cadastrar uma playlist.
     * @param nome nome que será atribuído a playlist.
     * @param descricao descricao que será atribuída a playlist.
     * Retorna FALSE se a playlist já existir, e TRUE se a playlist foi cadastrada
     * @return boolean.
     */
    public static boolean cadastrarPlaylist(String nome, String descricao) {
        if (playlistsCadastradas.contains(buscarPlaylistPorNome(nome))) {
            return false;
        }
        new Playlist(nome.trim(), descricao.trim());
        return true;
    }


    /**
     * Método para remover uma playlist cadastrada.
     * @param playlist playlist que será removida.
     * Retorna FALSE se a playlist não foi cadastrada antes, e TRUE se removida
     * @return boolean.
     */
    public static boolean removerPlaylist(Playlist playlist) {
        if (!playlist.getMusicas().isEmpty()) {
            return false;
        }
        playlistsCadastradas.remove(playlist);
        return true;
    }


    /**
     * Método para buscar uma playlist cadastrada pelo nome.
     * @param nome nome da playlist que será buscado.
     * Retorna a playlist se ela foi encontrada
     * @return String.
     */
    public static Playlist buscarPlaylistPorNome(String nome) {
        return playlistsCadastradas.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }


    /**
     * Método que busca uma playlist pelo seu index no ArrayList de playlists cadastradas.
     * @param index index da playlist que será buscada.
     * @return retorna a playlist se ela for encontrada.
     */
    public static Playlist playlistPorIndex(int index) {
        return playlistsCadastradas.get(index);
    }


    /**
     * Método para verificar a quantidade de playlists cadastradas.
     * Retorna a quantidade de playlists cadastradas.
     * @return inteiro.
     */
    public static int quantidadePlaylistsCadastradas() {
        return playlistsCadastradas.size();
    }

    /**
     * Método para verificar se o ArrayList de playlists cadastradas está vazio.
     * Retorna TRUE se o ArrayList de playlists cadastradas estiver vazio, e FALSE caso contrário.
     * @return boolean.
     */
    public static boolean isPlaylistsEmpty() {
        return playlistsCadastradas.isEmpty();
    }


    /**
     * Método que converte o ArrayList de playlists cadastradas em um vetor com seus respectivos nomes.
     * Retorna um vetor com os nomes das playlists cadastradas.
     * @return String
     */
    public static String[] arrayPlaylistsCadastradas() {
        String[] array = new String[playlistsCadastradas.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = playlistsCadastradas.get(i).getNome();
        }
        return array;
    }


    /**
     * Método que converte o Arraylist de musicas de uma playlist em um vetor de musicas.
     * @param playlist playlist que será convertida.
     * Retorna um vetor com as musicas da playlist.
     * @return String
     */
    public static String[] arrayMusicasNaPlaylist(Playlist playlist) {
        String[] array = new String[playlist.getMusicas().size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = playlist.getMusicas().get(i).getNome();
        }
        return array;
    }
}
