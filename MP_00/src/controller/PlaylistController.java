package controller;

import static model.Playlist.playlistsCadastradas;

import java.util.Objects;

import model.Musica;
import model.Playlist;

public class PlaylistController {

	private final Playlist playlist;
	
	// construtor
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

	public void removerMusica(Musica musica) {
		playlist.getMusicas().remove(musica);
	}

	public void atualizarPlaylist(String nome, String descricao) {
		playlist.setNome(nome);
		playlist.setDescricao(descricao);
	}

	public static boolean removerPlaylist(Playlist playlist) {
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

