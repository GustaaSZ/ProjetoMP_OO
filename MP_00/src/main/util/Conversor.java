package main.util;

import main.model.Artista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Classe com métodos para conversão de dados.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Conversor {

    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    /**
     * Método para converter uma string em uma data.
     * @param dataString string que será convertida.
     * @return retorna a data convertida.
     */
    public static Date stringToDate(String dataString) {
        try {
            return sdf.parse(dataString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para converter uma data em uma string.
     * @param data data que será convertida.
     * @return retorna a string convertida.
     */
    public static String dateToString(Date data) {
        return sdf.format(data);
    }

    /**
     * Método para converter uma lista de artistas em uma string.
     * @param artistas lista de artistas que será convertida.
     * @return retorna a string convertida.
     */
    public static String arrayListArtistaToString(ArrayList<Artista> artistas) {
        StringBuilder artistasString = new StringBuilder();
        for (int i = 0; i < artistas.size(); i++) {
            if (i < artistas.size() - 1) {
                artistasString.append(artistas.get(i).getNome()).append(", ");
            } else {
                artistasString.append(artistas.get(i).getNome()).append(".");
            }
        }
        return artistasString.toString();
    }
}