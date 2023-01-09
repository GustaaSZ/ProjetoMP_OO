package controller;

import model.Artista;
import model.Musica;

import java.util.Objects;

import static model.Musica.musicasCadastradas;

public class MusicaController {

    private final Musica musica;

    public MusicaController(Musica musica) {
        this.musica = musica;
    }

    // ----------------- METODOS DE EDICAO -----------------

    public void adicionarArtista(Artista artista) {
        if (musica.getArtistas().contains(artista)) {
            System.out.println("Artista ja cadastrado!");
            return;
        }
        musica.getArtistas().add(artista);
        artista.getMusicas().add(musica);
    }

    public void removerArtista(Artista artista) {
        if (!musica.getArtistas().contains(artista)) {
            System.out.println("Artista nao cadastrado!");
            return;
        }
        musica.getArtistas().remove(artista);
        artista.getMusicas().remove(musica);
    }

    public void listarArtistas() {
    	System.out.println("--------------------------------------------------");
        System.out.println("Artistas da musica " + musica.getNome() + ":");
        for (Artista artista : musica.getArtistas()) {
            System.out.println(artista);
        }
        System.out.println("--------------------------------------------------");
    }

    public void editarNome(String nome) {
        musica.setNome(nome);
    }

    public void editarLetra(String letra) {
        musica.getletra().setLetra(letra);
    }

    public int quantidadeArtistas() {
        return musica.getArtistas().size();
    }

    public int indexArtista(Artista artista) {
        return musica.getArtistas().indexOf(artista);
    }

    public Artista buscarArtistaPorIndex(int index) {
        return musica.getArtistas().get(index);
    }

    // ---------------- METODOS ESTATICOS ----------------

    public static void removerMusica(Musica musica) {
        if (!musicaExiste(musica)) {
            System.out.println("Musica nao cadastrada!");
            return;
        }
        musicasCadastradas.remove(musica);
        System.out.println("musica removida");

    }

    public static void listarTodasMusicasCadastradas() {
        for (Musica value : musicasCadastradas) {
            System.out.println(value);
        }
    }

    public static void buscarMusicaPorNome(String nome) {
        for (Musica value : musicasCadastradas) {
            if (Objects.equals(value.getNome(), nome)) {
                System.out.println(value);
                return;
            }
        }
        System.out.println("Musica nao encontrada!");
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
