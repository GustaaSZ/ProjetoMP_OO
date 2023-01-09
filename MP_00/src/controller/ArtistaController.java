package controller;

import static model.Artista.artistasCadastrados;
import static model.Musica.musicasCadastradas;

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
            System.out.println("Musica ja cadastrada!");
            return;
        }
        artista.getMusicas().add(musica);
        musica.getArtistas().add(artista);
    }

    public void removerMusica(Musica musica) {
        if (!artista.getMusicas().contains(musica)) {
            System.out.println("Musica nao cadastrada!");
            return;
        }
        artista.getMusicas().remove(musica);
        musica.getArtistas().remove(artista);
    }

    public void listarMusicas() {
    	System.out.println("--------------------------------------------------");
        System.out.println("Musicas do artista " + artista.getNome() + ":");
        for (Musica value : artista.getMusicas()) {
            System.out.println(value);
        }
        System.out.println("--------------------------------------------------");
    }

    public void editarNome(String nome) {
        artista.setNome(nome);
    }

    public int quantidadeMusicas() {
        return artista.getMusicas().size();
    }

    public int indexMusica(Musica musica) {
        return artista.getMusicas().indexOf(musica);
    }

    public Musica buscarMusicaPorIndex(int index) {
        return artista.getMusicas().get(index);
    }

    // ---------------- METODOS ESTATICOS ----------------

    public static void removerArtistaCadastrado(Artista artista) {
        if (!artistaExiste(artista)) {
            System.out.println("Artista nao cadastrado!");
            return;
        }
        if (artista.getMusicas().isEmpty()) {
            artistasCadastrados.remove(artista);
            System.out.println("artista removido");
        } else {
            System.out.println("Artista possui musicas cadastradas!");
        }
    }

    public static void listarTodosArtistasCadastrados() {
        for (Artista value : artistasCadastrados) {
            System.out.println(value);
        }
    }

    public static void buscarArtistaPorNome(String nome) {
        for (Artista value : artistasCadastrados) {
            if (Objects.equals(value.getNome(), nome)) {
                System.out.println(value);
                return;
            }
        }
        System.out.println("Artista nao encontrado!");
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
