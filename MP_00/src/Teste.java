import java.util.ArrayList;
import java.util.Date;

import controller.OuvinteController;
import model.Artista;
import model.LetraMusica;
import model.Musica;
import model.Ouvinte;
import model.Playlist;

public class Teste {
	 public static void main(String[] args) {
	        Artista artista1 = new Artista("Artista 1");
	        Artista artista2 = new Artista("Artista 2");
	        Artista artista3 = new Artista("Artista 3");
	        Artista artista4 = new Artista("Artista 4");
	        Artista artista5 = new Artista("Artista 5");
	        Artista artista6 = new Artista("Artista 6");
	        Artista artista7 = new Artista("Artista 7");
	        Artista artista8 = new Artista("Artista 8");
	        Artista artista9 = new Artista("Artista 9");
	        Artista artista10 = new Artista("Artista 10");

	        ArrayList<Artista> artistas1 = new ArrayList<>();
	        artistas1.add(artista1);
	        artistas1.add(artista2);
	        artistas1.add(artista3);
	        artistas1.add(artista4);

	        LetraMusica letra = new LetraMusica("letra");
	        
	        Musica musica1 = new Musica(artistas1, "Musica 1", letra, "rap", new Date());
	        Musica musica2 = new Musica(artistas1, "Musica 2", letra, "rap", new Date());
	        Musica musica3 = new Musica(artistas1, "Musica 3", letra, "rap", new Date());

	        ArrayList<Artista> artistas2 = new ArrayList<>();
	        artistas2.add(artista5);
	        artistas2.add(artista6);
	        artistas2.add(artista7);
	        artistas2.add(artista8);

	        Musica musica4 = new Musica(artistas2, "Musica 4", letra, "rap", new Date());
	        Musica musica5 = new Musica(artistas2, "Musica 5", letra, "rap", new Date());
	        Musica musica6 = new Musica(artistas2, "Musica 6", letra, "rap", new Date());

	        ArrayList<Artista> artistas3 = new ArrayList<>();
	        artistas3.add(artista9);
	        artistas3.add(artista10);

	        Musica musica7 = new Musica(artistas3, "Musica 7", letra, "rap", new Date());
	        Musica musica8 = new Musica(artistas3, "Musica 8", letra, "rap", new Date());


	        Playlist playlist1 = new Playlist("Playlist 1", "Descrição 1");
	        playlist1.adicionarMusica(musica1);
	        playlist1.adicionarMusica(musica2);
	        playlist1.adicionarMusica(musica3);

	        Playlist playlist2 = new Playlist("Playlist 2", "Descrição 2");
	        playlist2.adicionarMusica(musica4);
	        playlist2.adicionarMusica(musica5);
	        playlist2.adicionarMusica(musica6);

	        Playlist playlist3 = new Playlist("Playlist 3", "Descrição 3");
	        playlist3.adicionarMusica(musica7);
	        playlist3.adicionarMusica(musica8);

	        Ouvinte ouvinte1 = new Ouvinte("Ouvinte 1");
	        Ouvinte ouvinte2 = new Ouvinte("Ouvinte 2");
	        Ouvinte ouvinte3 = new Ouvinte("Ouvinte 3");
	        Ouvinte ouvinte4 = new Ouvinte("Ouvinte 4");

	        OuvinteController ouvinteController1 = new OuvinteController(ouvinte1);
	        OuvinteController ouvinteController2 = new OuvinteController(ouvinte2);
	        OuvinteController ouvinteController3 = new OuvinteController(ouvinte3);
	        OuvinteController ouvinteController4 = new OuvinteController(ouvinte4);

	        ouvinteController1.adicionarPlaylist(playlist1);
	        ouvinteController2.adicionarPlaylist(playlist2);
	        ouvinteController3.adicionarPlaylist(playlist3);
	        ouvinteController4.adicionarPlaylist(playlist1);

	        ouvinteController1.listarPlaylists();
	        ouvinteController2.listarPlaylists();

	        ArrayList<Artista> artistas10 = new ArrayList<>();
	        artistas10.add(artista1);

	        Musica musicaFavorita = new Musica(artistas10, "Musica Favorita", letra, "rap", new Date());
	        System.out.println(musicaFavorita);

	    }
	}

