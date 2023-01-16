package controller;

import static model.Musica.musicasCadastradas;
import static util.Conversor.stringToDate;

import java.util.ArrayList;
import java.util.Objects;

import model.Artista;
import model.Musica;
import java.text.ParseException;

public class MusicaController {

	private final Musica musica;
	
	// construtor
	public MusicaController(Musica musica) {
		this.musica = musica;
	}
	
	// Métodos de Edição do CRUD
	
	//------------------ FUNÇÃO DE ADD ARTISTA NA MUSICA --------------------
	
	public boolean adicionarArtista(Artista artista) {
		
		if(musica.getArtistas().contains(artista)) {
			return false;
		}
		// Add o artista á musica
		musica.getArtistas().add(artista);
		
		// add a musica no artista
		artista.getMusicas().add(musica);
		return true;
	}
	
//	---------------------------------------------------------------
	
	public boolean adicionarArtistas(ArrayList<Artista> artistas) {
		//musica nao pode ter artista repetido
		for (Artista artista : artistas) {
			if (musica.getArtistas().contains(artista)) {
				return false;
			}
		}
		musica.getArtistas().addAll(artistas);
		for (Artista artista : artistas) {
			artista.getMusicas().add(musica);
		}
		return true;
	}
	
			
	//------------------- FUNÇÃO DE REMOVER ARTISTA DA MUSICA ---------------------
			
	public boolean removerArtista(Artista artista) {
		
		// Lendo todos os artistas que estão cadastrados á determinada musica, se esse artista n for encontrado...
		if(!musica.getArtistas().contains(artista)) {
            return false;
		}
		if (musica.getArtistas().size() == 1) {
			return false;
		}
		// remove artista da musica
		musica.getArtistas().remove(artista);
		
		// remove musica do artista
		artista.getMusicas().remove(musica);
		return true;
	}
	
	//------------------- FUNÇÃO DE ATT MUSICA ---------------------
	
	public void atualizarMusica(String nome, String genero, String lancamento, String letra) {
		try {
		musica.setNome(nome);
		musica.setGenero(genero);
		musica.setLancamento(stringToDate(lancamento));
		musica.setLetra(letra);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
//	---------------------------------------------------------------
	
	// Método de editar nome da Musica
	
	public void editarNome(String nome) {
		musica.setNome(nome);
	}
	
	// Método de editar letra da Musica
	
	public void editarLetra(String letra) {
		musica.setLetra(letra);
	}
	
	public int indexArtista(Artista artista) {
        return musica.getArtistas().indexOf(artista);
    }

    public Artista buscarArtistaPorIndex(int index) {
        return musica.getArtistas().get(index);
    }
	
    // ---------------- METODOS ESTATICOS ----------------
    
    //Manipulando as musicas 
    
    public static boolean removerMusica(Musica musica) {
    	
    	// Se ao tentar remover a musica, e ela não estiver cadastrada...
    	if(!musicaExiste(musica)) {
            return false;
    	}
    	// removendo a musica
    	musicasCadastradas.remove(musica);
        return true;
    }
    
    public static Musica buscarMusicaPorNome(String nome) {
    	
        for (Musica value : musicasCadastradas) {
            if (Objects.equals(value.getNome(), nome)) {
                return value;
            }
        }
		return null;
    }

    
    private static Boolean musicaExiste(Musica musica) {
        for (Musica value : musicasCadastradas) {
            if (Objects.equals(musica, value)) {
                return true;
            }
        }
        return false;
    }
    
}

