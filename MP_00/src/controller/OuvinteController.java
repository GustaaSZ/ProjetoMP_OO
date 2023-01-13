package controller;

import model.Musica;
import model.Ouvinte;
import model.Playlist;

import static model.Ouvinte.ouvintesCadastrados;
import static model.Playlist.playlistsCadastradas;

import java.util.ArrayList;
import java.util.Objects;

public class OuvinteController {

	// Instânciando um objeto ouvinte da classe ouvinte para a classe de controle
	
	private final Ouvinte ouvinte;
	
	// Construtor
	
	public OuvinteController(Ouvinte ouvinte) {
		this.ouvinte = ouvinte;
	}
	
//	-----------------------------------------------------------------------------

	// Método de add Playlist ao ouvinte
	
	public boolean adicionarPlaylist(Playlist playlist) {
		
		// Se a playlist já existir ao tentar add ela, será mostrada a seguinte mensagem
		if(ouvinte.getPlaylists().contains(playlist)) {
			System.out.println("Playlist já Cadastrada!");
            return false;
		}
		// Adicionando a ouvinte á lista de playlists
		ouvinte.getPlaylists().add(playlist);
		
		// Adicionando a playlist á um ouvinte
		playlist.getOuvintes().add(ouvinte);
		
		return true;
    }
	
//	-----------------------------------------------------------------------------
	
	public boolean adicionarPlaylist(ArrayList<Playlist> playlists) {
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

	// Método de remover Playlist ao ouvonte
	
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

	// Método de adicionar Musica favorita do ouvinte
	
	public void adicionarMusicaFavorita(Musica musica) {
		ouvinte.setMusicaFavorita(musica);
	}
	
//	-----------------------------------------------------------------------------

	public void editarNome(String nome) {
		ouvinte.setNome(nome);
    }

    public int quantidadePlaylists() {
        return ouvinte.getPlaylists().size();
    }

    public int indexPlaylist(Playlist playlist) {
        return ouvinte.getPlaylists().indexOf(playlist);
    }

    public Playlist buscarPlaylistPorIndex(int index) {
        return ouvinte.getPlaylists().get(index);
    }
	
//	 ********************************* METODOS ESTATICOS *********************************
    
    // Método de remover Ouvinte
	public static boolean removerOuvinteCadastrado(Ouvinte ouvinte) {
		
	// Se ao tentar remover um ouvinte, chamamos o método ouvinte existe,
	// e nele verificamos se ouvinte que deseja-se excluir existe de fato!
		
        if (!ouvinteExiste(ouvinte)) {
//            System.out.println("Ouvinte não cadastrado!");
            return false;
        }
        
        // Pegando a lista de playlists do ouvinte e removendo
        if (ouvinte.getPlaylists().isEmpty()) {
            ouvintesCadastrados.remove(ouvinte);
            return true;
        } else {
            return false;
        }
    }
	
	
//	-----------------------------------------------------------------------------
	
	// Método de buscar Playlist por nome
	
	public static Playlist buscarPlaylistPorNome(String nome) {
		
		for(Playlist value : playlistsCadastradas) {
			if(value.getNome().equals(nome)) {
				return value;
			}
		}
		return null;
	}
	
//		-----------------------------------------------------------------------------
	 
	 // Método que fara uam busca por nome de um ouvinte que o usuário deseja
	 public static Ouvinte buscarOuvintePorNome(String nome) {
		 
		 // Contador que percorre a quantidade de ouvintes cadastrados
	        for (Ouvinte value : ouvintesCadastrados) {
	        	
	        	// Se o nome digitado pelo usuário for encontrado na lista de ouvintesCadastrados ele retorna o nome
	            if (Objects.equals(value.getNome(), nome)) {
	                return value;
	            }
	        }
	        // Ao sair condição, se o nome digitado não foi encontrado na lista
	        // de ouvintesCadastrados, mostra a seguinte mensagem na tela do usuário!
			return null;
    }
	 
//		-----------------------------------------------------------------------------
	 
	 // Método que verifica se um ouvinte existe de fato.
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