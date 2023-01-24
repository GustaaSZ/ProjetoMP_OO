package main.controller;

import main.model.Ouvinte;
import main.model.Playlist;

import static main.model.Ouvinte.ouvintesCadastrados;

public class OuvinteController {
    private final Ouvinte ouvinte;

    public OuvinteController(Ouvinte ouvinte) {
        this.ouvinte = ouvinte;
    }

//	-----------------------------------------------------------------------------

    public boolean adicionarPlaylist(Playlist playlist) {
        if (ouvinte.getPlaylists().contains(playlist)) {
            return false;
        }
        // Adicionando a ouvinte á lista de playlists
        ouvinte.getPlaylists().add(playlist);
        return true;
    }

//	-----------------------------------------------------------------------------

    public boolean removerPlaylist(Playlist playlist) {
        if (!ouvinte.getPlaylists().contains(playlist)) {
            return false;
        }
        // Removendo o ouvinte da Playlist
        ouvinte.getPlaylists().remove(playlist);
        return true;
    }

    //	-----------------------------------------------------------------------------
    
    public void editarOuvinte(String nome, String musicaFavorita) {
        ouvinte.setNome(nome);
        ouvinte.setMusicaFavorita(musicaFavorita);
    }

//	 ********************************* METODOS ESTATICOS *********************************

    public static void cadastrarOuvinte(String nome, String musicaFavorita) {
        if (!ouvinteExiste(buscarOuvintePorNome(nome))) {
            return;
        }
        new Ouvinte(nome.trim(), musicaFavorita.trim());
    }

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

    public static Ouvinte buscarOuvintePorNome(String nome) {
        return ouvintesCadastrados.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public static Ouvinte ouvintePorIndex(int index) {
        return ouvintesCadastrados.get(index);
    }

    public static int quantidadeOuvintesCadastrados() {
        return ouvintesCadastrados.size();
    }

    public static boolean isOuvintesEmpty() {
        return ouvintesCadastrados.isEmpty();
    }

    public static Ouvinte[] arrayOuvintesCadastrados() {
        return ouvintesCadastrados.toArray(new Ouvinte[0]);
    }

    public static Playlist[] arrayPlaylistsPorOuvinte(Ouvinte ouvinte) {
        return ouvinte.getPlaylists().toArray(new Playlist[0]);
    }

    private static Boolean ouvinteExiste(Ouvinte ouvinte) {
        return ouvintesCadastrados.contains(ouvinte);
    }

}