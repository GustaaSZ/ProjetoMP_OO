package controller;

import static model.Artista.artistasCadastrados;

import java.util.Objects;

import model.Artista;
import model.Musica;

public class ArtistaController {

    private final Artista artista;

    public ArtistaController(Artista artista) {
        this.artista = artista;
    }

    // ----------------- METODOS NAO ESTATICOS -----------------

    public void adicionarMusica(Musica musica) {
        if (artista.getMusicas().contains(musica)) {
            return;
        }
        artista.getMusicas().add(musica);
        musica.getArtistas().add(artista);
    }

    public void removerMusica(Musica musica) {
        if (!artista.getMusicas().contains(musica)) {
            return;
        }
        artista.getMusicas().remove(musica);
        musica.getArtistas().remove(artista);
    }

    public void editarNome(String nome) {
        artista.setNome(nome);
    }

    // ---------------- METODOS ESTATICOS ----------------

    public static boolean removerArtistaCadastrado(Artista artista) {
        if (!artistaExiste(artista)) {
            return false;
        }
        if (artista.getMusicas().isEmpty()) {
            artistasCadastrados.remove(artista);
            return true;
        } else {
            return false;
        }
    }

    public static Artista buscarArtistaPorNome(String nome) {
        for (Artista value : artistasCadastrados) {
            if (value.getNome().trim().equalsIgnoreCase(nome)) {
                return value;
            }
        }
		return null;
    }

    private static Boolean artistaExiste(Artista artista) {
        for (Artista value : artistasCadastrados) {
            if (Objects.equals(artista, value)) {
                return true;
            }
        }
        return false;
    }
}
