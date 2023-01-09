package controller;

import static model.Musica.musicasCadastradas;

import java.util.Objects;

import javax.swing.JOptionPane;

import model.Artista;
import model.Musica;

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
			JOptionPane.showMessageDialog(null, "Erro ao remover a música!");
			return;
		}
		musicasCadastradas.remove(musica);
	}

	public static void listarTodasMusicasCadastradas() {
		for (Musica value : musicasCadastradas) {
			System.out.println(value);
		}
	}

	public static Musica buscarMusicaPorNome(String nome) {
		for (Musica value : musicasCadastradas) {
			if (Objects.equals(value.getNome(), nome)) {
				return value;
			}
		}
		JOptionPane.showMessageDialog(null, "Não foi possível encontrar a música!");
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
