package main.controller;

import main.model.Ouvinte;
import main.model.Playlist;

import java.util.ArrayList;
import java.util.Objects;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;

public class OuvinteController {
	private final Ouvinte ouvinte;
	
	public OuvinteController(Ouvinte ouvinte) {
		this.ouvinte = ouvinte;
	}
	
//	-----------------------------------------------------------------------------
	
	public boolean adicionarPlaylist(Playlist playlist) {
		if(ouvinte.getPlaylists().contains(playlist)) {
            return false;
		}
		// Adicionando a ouvinte á lista de playlists
		ouvinte.getPlaylists().add(playlist);
		
		// Adicionando a playlist á um ouvinte
		playlist.getOuvintes().add(ouvinte);
		
		return true;
    }
	
//	-----------------------------------------------------------------------------
	
	public boolean adicionarPlaylists(ArrayList<Playlist> playlists) {
		//musica nao pode ter artista repetido
		for (Playlist playlist : playlists) {
			if (ouvinte.getPlaylists().contains(playlist)) {
				return false;
			}
		}
		ouvinte.getPlaylists().addAll(playlists);
		for (Playlist playlist : playlists) {
			playlist.getOuvintes().add(ouvinte);
		}
		return true;
	}
	
	
//	-----------------------------------------------------------------------------
	
	public boolean removerPlaylist(Playlist playlist) {
		if (!ouvinte.getPlaylists().contains(playlist)) {
			return false;
		}
		// Removendo o ouvinte da Playlist
        ouvinte.getPlaylists().remove(playlist);
        
        // Removendo a playlist do ouvinte ouvinte
 		playlist.getOuvintes().remove(ouvinte);
		return true;
    }

	
//	-----------------------------------------------------------------------------

	public void editarNome(String nome) {
		ouvinte.setNome(nome);
    }
	
//	 ********************************* METODOS ESTATICOS *********************************

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

//	-----------------------------------------------------------------------------
	public static Playlist buscarPlaylistPorNome(String nome) {
		for(Playlist value : playlistsCadastradas) {
			if(value.getNome().equals(nome)) {
				return value;
			}
		}
		return null;
	}
	
//		-----------------------------------------------------------------------------
	 public static Ouvinte buscarOuvintePorNome(String nome) {
		 
		 // Contador que percorre a quantidade de ouvintes cadastrados
	        for (Ouvinte value : ouvintesCadastrados) {
	        	
	        	// Se o nome digitado pelo usuário for encontrado na lista de ouvintesCadastrados ele retorna o Ouvinte
	            if (value.getNome().trim().equalsIgnoreCase(nome)) {
	                return value;
	            }
	        }
			return null;
	    }
//		-----------------------------------------------------------------------------
	 private static Boolean ouvinteExiste(Ouvinte ouvinte){
		 // Repetição que vai percorrer a quantidade de ouvintes cadastrados
	        for (Ouvinte value : ouvintesCadastrados) {
	        	// Se o ouvinte for encontrado, retorna true
	            if (Objects.equals(ouvinte, value)) {
	                return true;
	            }
	        }
	        return false;
     }
	
}