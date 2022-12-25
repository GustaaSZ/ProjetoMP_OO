package controller;

import model.Musica;
import model.Ouvinte;
import model.Playlist;

public class OuvinteController {
    private final Ouvinte ouvinte;

    public OuvinteController(Ouvinte ouvinte) {
        this.ouvinte = ouvinte;
    }

    public void adicionarPlaylist(Playlist playlist) {
        ouvinte.getPlaylists().add(playlist);
    }

    public void removerPlaylist(Playlist playlist) {
        ouvinte.getPlaylists().remove(playlist);
    }

    public void listarPlaylists() {
    	System.out.println("--------------------------------------------------");
        System.out.println("Playlists do ouvinte " + ouvinte.getNome() + ":");
        for (Playlist value : ouvinte.getPlaylists()) {
            System.out.println(value);
        }
        System.out.println("--------------------------------------------------");
    }

    public void buscarPlaylistPorNome(String nome) {
        for (Playlist value : ouvinte.getPlaylists()) {
            if (value.getNome().equals(nome)) {
                System.out.println(value);
            }
        }
    }

    public void adicionarMusicaFavorita(Musica musica) {
        ouvinte.setMusicaFavorita(musica);
    }
}

