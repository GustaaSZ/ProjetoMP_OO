package main.util;

import main.controller.OuvinteController;
import main.controller.PlaylistController;
import main.model.Artista;
import main.model.Musica;
import main.model.Ouvinte;
import main.model.Playlist;

import java.util.Date;

public class Instanciacao {
	public static void instanciar() {
		Artista artista1 = new Artista("Djonga");
		Artista artista2 = new Artista("Froid");
		Artista artista3 = new Artista("Veigh");
		Artista artista4 = new Artista("Yunk Vino");
		Artista artista5 = new Artista("Kyan");
		Artista artista6 = new Artista("Leviano");

		Musica musica1 = new Musica(artista1, "O Mundo é Nosso", "aaaaaa", "Rap", new Date());
		Musica musica2 = new Musica(artista2, "Peita de dar Rolê", "bbb", "Rap", new Date());
		Musica musica3 = new Musica(artista3, "Mil Maneiras", "cccccc", "Trap", new Date());
		Musica musica4 = new Musica(artista4, "237", "dddddddddd", "Trap", new Date());
		Musica musica5 = new Musica(artista5, "Mandrake", "eeeeeeee", "Drill", new Date());
		Musica musica6 = new Musica(artista6, "Quieto", "fffffffff", "Trap", new Date());

		Playlist playlist1 = new Playlist("Rap", "Descrição 1");

		PlaylistController controller1 = new PlaylistController(playlist1);

		controller1.adicionarMusica(musica1);
		controller1.adicionarMusica(musica2);
		controller1.adicionarMusica(musica3);

		Playlist playlist2 = new Playlist("Rock", "Descrição 2");
		Playlist playlist3 = new Playlist("Samba", "Descrição 3");
		PlaylistController controller2 = new PlaylistController(playlist2);
		
		controller2.adicionarMusica(musica4);
		controller2.adicionarMusica(musica5);
		controller2.adicionarMusica(musica6);

		Ouvinte ouvinte1 = new Ouvinte("Joãozinho");
		Ouvinte ouvinte2 = new Ouvinte("Maria");
		Ouvinte ouvinte3 = new Ouvinte("Pedro");

		OuvinteController ouvinteController1 = new OuvinteController(ouvinte1);
		OuvinteController ouvinteController2 = new OuvinteController(ouvinte2);
		OuvinteController ouvinteController3 = new OuvinteController(ouvinte3);

		ouvinteController1.adicionarPlaylist(playlist1);
		ouvinteController1.adicionarPlaylist(playlist2);

		ouvinteController2.adicionarPlaylist(playlist1);
		ouvinteController2.adicionarPlaylist(playlist3);

		ouvinteController3.adicionarPlaylist(playlist2);
		ouvinteController3.adicionarPlaylist(playlist3);
	}
}
