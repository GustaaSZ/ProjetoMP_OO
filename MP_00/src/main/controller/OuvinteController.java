package main.controller;

import main.model.Ouvinte;
import main.model.Playlist;

// import static main.model.Artista.artistasCadastrados;
import static main.model.Ouvinte.ouvintesCadastrados;


/**
 * Classe com métodos para manipulação dos Ouvintes.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class OuvinteController {
    private final Ouvinte ouvinte;

    public OuvinteController(Ouvinte ouvinte) {
        this.ouvinte = ouvinte;
    }


    /**
     * Método para adicionar uma playlist a um ouvinte.
     * @param playlist playlist que será adicionada.
     * Retorna TRUE se a playlist for adicionada, e FALSE se a playlist já foi adicionada ao ouvinte
     * @return boolean.
     */
    public boolean adicionarPlaylist(Playlist playlist) {
        if (ouvinte.getPlaylists().contains(playlist)) {
            return false;
        }
        // Adicionando a ouvinte á lista de playlists
        ouvinte.getPlaylists().add(playlist);
        return true;
    }


    /**
     * Método para remover uma playlist de um ouvinte.
     * @param playlist playlist que será removida.
     * Retorna TRUE se a playlist for removida e FALSE se ela não foi encontrada no ouvinte, sendo assim não pode ser removida
     * @return boolean.
     */
    public boolean removerPlaylist(Playlist playlist) {
        if (!ouvinte.getPlaylists().contains(playlist)) {
            return false;
        }
        // Removendo o ouvinte da Playlist
        ouvinte.getPlaylists().remove(playlist);
        return true;
    }

    
    /**
     * Método para atualizar os dados do ouvinte.
     * @param nome nome que será atribuído ao ouvinte.
     * @param musicaFavorita musicaFavorita que será atribuído ao ouvinte.
     */
    public void editarOuvinte(String nome, String musicaFavorita) {
        ouvinte.setNome(nome);
        ouvinte.setMusicaFavorita(musicaFavorita);
    }

//	 ********************************* METODOS ESTATICOS *********************************


    /**
     * Método para cadastrar um ouvinte.
     * @param nome nome que será atribuído ao ouvinte.
     * @param musicaFavorita musicaFavorita que será atribuída ao ouvinte.
     * Verifica se o ouvinte já foi cadastrado, se não, é cadastrado com sucesso
     * Não retorna nada
     */
    public static void cadastrarOuvinte(String nome, String musicaFavorita) {
        if (!ouvinteExiste(buscarOuvintePorNome(nome))) {
            return;
        }
        new Ouvinte(nome.trim(), musicaFavorita.trim());
    }


    /**
     * Método para remover um ouvinte cadastrado.
     * @param ouvinte ouvinte que será removido.
     * Retorna FALSE se o ouvinte não foi cadastrada antes, e TRUE se removida
     * @return boolean.
     */
    public static boolean removerOuvinteCadastrado(Ouvinte ouvinte) {
        if (!ouvinteExiste(ouvinte)) {
            return false;
        }
        if (ouvinte.getPlaylists().isEmpty()) {
            ouvintesCadastrados.remove(ouvinte);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Método para buscar um ouvinte cadastrada pelo nome.
     * @param nome nome do ouvinte que será buscado.
     * Retorna o ouvinte se ele foi encontradp
     * @return String.
     */
    public static Ouvinte buscarOuvintePorNome(String nome) {
        return ouvintesCadastrados.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }


    /**
     * Método que busca um ouvinte pelo seu index no ArrayList de ouvintes cadastrados.
     * @param index index do ouvinte que será buscado.
     * @return retorna o ouvinte se ele for encontrado.
     */
    public static Ouvinte ouvintePorIndex(int index) {
        return ouvintesCadastrados.get(index);
    }


    /**
     * Método para verificar a quantidade de ouvintes cadastrados.
     * Retorna a quantidade de ouvintes cadastradas
     * @return inteiro.
     */
    public static int quantidadeOuvintesCadastrados() {
        return ouvintesCadastrados.size();
    }


    /**
     * Método para verificar se o ArrayList de ouvintes cadastradas está vazio.
     * Retorna TRUE se o ArrayList de ouvintes cadastradas estiver vazio, e FALSE caso contrário.
     * @return boolean.
     */
    public static boolean isOuvintesEmpty() {
        return ouvintesCadastrados.isEmpty();
    }


    /**
    * Método que converte o ArrayList de ouvintes cadastradas em um vetor com seus respectivos nomes.
    * Retorna um vetor com os nomes dos ouvintes cadastrados.
    * @return String
    */
    public static String[] arrayOuvintesCadastrados() {
    	String[] array = new String[ouvintesCadastrados.size()];
    	for (int i = 0; i < array.length; i++) {
            array[i] = ouvintesCadastrados.get(i).getNome();
        }
        return array;
    }

    /**
     * Método que converte o ArrayList de playlists de um ouvinte em um vetor de playlists.
     * @param ouvinte ouvinte que deseja converter o ArrayList de playlists.
     * Retorna o vetor de playlists.
     * @return String.
     */
    public static Playlist[] arrayPlaylistsPorOuvinte(Ouvinte ouvinte) {
        return ouvinte.getPlaylists().toArray(new Playlist[0]);
    }

    /**
     * Método para verificar se um ouvinte existe.
     * @param ouvinte ouvinte que será verificado.
     * Retorna true se o ouvinte existir e FALSE caso contrário.
     * @return boolean
     */
    private static Boolean ouvinteExiste(Ouvinte ouvinte) {
        return ouvintesCadastrados.contains(ouvinte);
    }

}