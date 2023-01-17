package main.controller;

import main.model.Artista;
import main.model.Musica;

import java.text.ParseException;
import java.util.Objects;

import static main.model.Musica.musicasCadastradas;
import static main.util.Conversor.stringToDate;

public class MusicaController {

	private final Musica musica;

	public MusicaController(Musica musica) {
		this.musica = musica;
	}
	
	//------------------ FUNÇÃO DE ADD ARTISTA NA MUSICA --------------------
	
	public boolean adicionarArtista(Artista artista) {
		if(musica.getArtistas().contains(artista)) {
			return false;
		}
		musica.getArtistas().add(artista);
		artista.getMusicas().add(musica);
		return true;
	}
//	---------------------------------------------------------------
	public boolean removerArtista(Artista artista) {
		if(!musica.getArtistas().contains(artista)) {
            return false;
		}
		if (musica.getArtistas().size() == 1) {
			return false;
		}
		musica.getArtistas().remove(artista);
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
    // ---------------- METODOS ESTATICOS ----------------
    public static boolean removerMusica(Musica musica) {
    	if(!musicaExiste(musica)) {
            return false;
    	}
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

