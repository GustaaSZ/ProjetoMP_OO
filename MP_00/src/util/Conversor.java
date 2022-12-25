package util;

import model.Artista;
import model.Musica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Conversor {

    public static Date stringToDate(String dataString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return sdf.parse(dataString);
    }

    public static String dateToString(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return sdf.format(data);
    }

    public static String arrayListArtistaToString(ArrayList<Artista> artistas) {
        StringBuilder artistasString = new StringBuilder();
        for (int i = 0; i < artistas.size(); i++) {
            if (i < artistas.size() - 1) {
                artistasString.append(artistas.get(i).getNome()).append(", ");
            } else {
                artistasString.append(artistas.get(i).getNome());
            }
        }
        return artistasString.toString();
    }

    public static String arrayListMusicaToString(ArrayList<Musica> musicas) {
        StringBuilder musicasString = new StringBuilder();
        for (int i = 0; i < musicas.size(); i++) {
            if (i < musicas.size() - 1) {
                musicasString.append(musicas.get(i).getNome()).append(", ");
            } else {
                musicasString.append(musicas.get(i).getNome());
            }
        }
        return musicasString.toString();
    }
}
