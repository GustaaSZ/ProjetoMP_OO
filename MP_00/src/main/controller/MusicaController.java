package main.controller;

import main.model.Artista;
import main.model.Musica;

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
		musica.setNome(nome);
		musica.setGenero(genero);
		musica.setLancamento(stringToDate(lancamento));
		musica.setLetra(letra);
	}
    // ---------------- METODOS ESTATICOS ----------------

	public static boolean cadastrarMusica(Artista artista, String nome, String letra, String genero, String lancamento) {
			if(!musicaExiste(buscarMusicaPorNome(nome))) {
				new Musica(artista, nome.trim(), letra.trim(), genero.trim(), stringToDate(lancamento));
				return true;
			}
			return false;
	}
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
        return musicasCadastradas.contains(musica);
    }
}

