package util;

import java.util.Date;

import controller.PlaylistController;
import model.Artista;
import model.LetraMusica;
import model.Musica;
import model.Ouvinte;
import model.Playlist;

public class Instanciacao {
	public static void instanciar() {
		Artista artista1 = new Artista("Artista 1");
		Artista artista2 = new Artista("Artista 2");
		Artista artista3 = new Artista("Artista 3");
		Artista artista4 = new Artista("Artista 4");
		Artista artista5 = new Artista("Artista 5");
		Artista artista6 = new Artista("Artista 6");

		Musica musica1 = new Musica(artista1, "Musica 1", new LetraMusica("letra"), "rap", new Date());
		Musica musica2 = new Musica(artista2, "Musica 2", new LetraMusica("letra"), "rap", new Date());
		Musica musica3 = new Musica(artista3, "Musica 3", new LetraMusica("letra"), "rap", new Date());
		Musica musica4 = new Musica(artista4, "Musica 4", new LetraMusica("letra"), "rap", new Date());
		Musica musica5 = new Musica(artista5, "Musica 5", new LetraMusica("letra"), "rap", new Date());
		Musica musica6 = new Musica(artista6, "Musica 6", new LetraMusica("letra"), "rap", new Date());

		Playlist playlist1 = new Playlist("Playlist 1", "Descrição 1");

		PlaylistController controller1 = new PlaylistController(playlist1);

		controller1.adicionarMusica(musica1);
		controller1.adicionarMusica(musica2);
		controller1.adicionarMusica(musica3);

		Playlist playlist2 = new Playlist("Playlist 2", "Descrição 2");
		PlaylistController controller2 = new PlaylistController(playlist2);

		controller2.adicionarMusica(musica4);
		controller2.adicionarMusica(musica5);
		controller2.adicionarMusica(musica6);

		Ouvinte ouvinte1 = new Ouvinte("Joãozinho");
		Ouvinte ouvinte2 = new Ouvinte("Maria");
		Ouvinte ouvinte3 = new Ouvinte("Pedro");
	}
}
