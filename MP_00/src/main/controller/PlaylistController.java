package main.controller;

import main.model.Musica;
import main.model.Playlist;

import java.util.Objects;

import static main.model.Playlist.playlistsCadastradas;

public class PlaylistController {

	private final Playlist playlist;

	public PlaylistController(Playlist playlist) {
		this.playlist = playlist;
	}
	
	// Métodos de Edição do CRUD
	public boolean adicionarMusica(Musica musica) {
		if (playlist.getMusicas().contains(musica)) {
			return false;
		}
		playlist.getMusicas().add(musica);
		return true;
	}

	public boolean removerMusica(Musica musica) {
		if (!playlist.getMusicas().contains(musica)) {
			return false;
		}
		playlist.getMusicas().remove(musica);
		return true;
	}

	public void atualizarPlaylist(String nome, String descricao) {
		playlist.setNome(nome);
		playlist.setDescricao(descricao);
	}

	public static boolean cadastrarPlaylist(String nome, String descricao) {
		if (playlistsCadastradas.contains(buscarPlaylistPorNome(nome))){
			return false;
		}
		new Playlist(nome.trim(), descricao.trim());
		return true;
	}

	public static boolean removerPlaylist(Playlist playlist) {
		if (!playlist.getMusicas().isEmpty()) {
			return false;
		}

		playlistsCadastradas.remove(playlist);
		return true;
	}
	
	public static Playlist buscarPlaylistPorNome(String nome) {
        for (Playlist value : playlistsCadastradas) {
            if (Objects.equals(value.getNome(), nome)) {
                return value;
            }
        }
		return null;
    }
}

