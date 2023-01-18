package main.controller;

import main.model.Ouvinte;
import main.model.Playlist;

import java.util.Objects;

import static main.model.Ouvinte.ouvintesCadastrados;

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
	public void editarNome(String nome) {
		ouvinte.setNome(nome);
    }
	
//	 ********************************* METODOS ESTATICOS *********************************

	public static boolean cadastrarOuvinte(String nome) {
		if (!ouvinteExiste(buscarOuvintePorNome(nome))) {
			return false;
		}
		new Ouvinte(nome.trim());
		return true;
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