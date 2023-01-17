package main.util;

import main.model.Artista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Conversor {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    public static Date stringToDate(String dataString) throws ParseException {
        return sdf.parse(dataString);
    }

    public static String dateToString(Date data) {
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
}