package main.controller;

import main.model.Artista;
import main.model.Musica;

import static main.model.Artista.artistasCadastrados;

public class ArtistaController {

    private final Artista artista;

    public ArtistaController(Artista artista) {
        this.artista = artista;
    }

    public void editarNome(String nome) {
        artista.setNome(nome);
    }

    // ---------------- METODOS ESTATICOS ----------------
    public static boolean cadastrarArtista(String nome) {
        if (!artistaExiste(buscarArtistaPorNome(nome))) {
            new Artista(nome.trim());
            return true;
        }
        return false;
    }

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
        return artistasCadastrados.stream()
                .filter(value -> value.getNome().trim().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public static Artista artistaPorIndex(int index) {
        return artistasCadastrados.get(index);
    }

    public static int quantidadeArtistasCadastrados() {
        return artistasCadastrados.size();
    }

    public static boolean isArtistasEmpty() {
        return artistasCadastrados.isEmpty();
    }

    public static Artista[] arrayArtistasCadastrados() {
        return artistasCadastrados.toArray(new Artista[0]);
    }

    public static Musica[] arrayMusicasDoArtista(Artista artista) {
        return artista.getMusicas().toArray(new Musica[0]);
    }

    private static Boolean artistaExiste(Artista artista) {
        return artistasCadastrados.contains(artista);
    }
}
