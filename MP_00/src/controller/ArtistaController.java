package controller;

import static model.Artista.artistasCadastrados;

import java.util.Objects;

import javax.swing.JOptionPane;

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
//            System.out.println("Musica ja cadastrada!");
            return;
        }
        artista.getMusicas().add(musica);
        musica.getArtistas().add(artista);
    }

    public void removerMusica(Musica musica) {
        if (!artista.getMusicas().contains(musica)) {
//            System.out.println("Musica nao cadastrada!");
            return;
        }
        artista.getMusicas().remove(musica);
        musica.getArtistas().remove(artista);
    }

//    public void listarMusicas() {
//    	System.out.println("--------------------------------------------------");
//        System.out.println("Musicas do artista " + artista.getNome() + ":");
//        for (Musica value : artista.getMusicas()) {
//            System.out.println(value);
//        }
//        System.out.println("--------------------------------------------------");
//    }

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

    public static boolean removerArtistaCadastrado(Artista artista) {
        if (!artistaExiste(artista)) {
//            System.out.println("Artista nao cadastrado!");
            return false;
        }
        if (artista.getMusicas().isEmpty()) {
            artistasCadastrados.remove(artista);
//            System.out.println("artista removido");
            return true;
        } else {
//            System.out.println("Artista possui musicas cadastradas!");
            return false;
        }
    }

    public static void listarTodosArtistasCadastrados() {
        for (Artista value : artistasCadastrados) {
            System.out.println(value);
        }
    }

    public static Artista buscarArtistaPorNome(String nome) {
        for (Artista value : artistasCadastrados) {
            if (Objects.equals(value.getNome(), nome)) {
                return value;
            }
        }
//        JOptionPane.showMessageDialog(null, "Não foi possível encontrar o artista!");
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
