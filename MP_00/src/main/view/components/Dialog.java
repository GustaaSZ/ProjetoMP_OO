package main.view.components;

import main.model.Artista;
import main.model.Ouvinte;

import javax.swing.*;

import static main.util.AesthethicsView.*;
import static main.util.AesthethicsView.getCorLetra;

public class Dialog {
    public static void openDialog(String type) {
        setColor();
        switch (type.toLowerCase().trim()) {
            case "artista" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre um artista primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "musica" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre uma música primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "ouvinte" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre um ouvinte primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "playlist" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre uma playlist primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "artista_musica" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre uma música e um artista primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "success" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Operação realizada com sucesso!",
                            "Sucesso!",
                            JOptionPane.INFORMATION_MESSAGE);
            case "artista_repetido" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Artista já pertence a música!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "playlist_not_null" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Playlist possui músicas cadastradas," +
                                    " remova elas para excluir a playlist!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "musica_sem_artista" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Música não pode ficar sem artista cadastrado!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "playlist_vazia" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Nenhuma música cadastrada para esta playlist!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "playlist_repetida" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Ouvinte já possui essa playlist cadastrada!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "artista_nao_encontrado" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Artista não encontradado",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "ouvinte_nao_encontrado" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Ouvinte não encontradado",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            default ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Falha ao realizar a operação!",
                            "Erro!",
                            JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean objetoEncontrado(Object o) {
        setColor();
        if (o instanceof Artista) {
            JOptionPane.showMessageDialog(
                    null,
                    "Artista " + ((Artista) o).getNome() + " encontrado, operação realizada com sucesso!",
                    "Artista Encontrado!",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        if (o instanceof Ouvinte) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ouvinte " + ((Ouvinte) o).getNome() + " encontrado, operação realizada com sucesso!",
                    "Ouvinte Encontrado!",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    private static void setColor(){
        UIManager.put("Panel.background",getCorFundo());
        UIManager.put("OptionPane.background", getCorFundoBtn());
        UIManager.put("OptionPane.buttonFont", getFonteMenor());
        UIManager.put("OptionPane.messageForeground", getCorLetra());
        UIManager.put("Button.background", getCorLetra());
    }
}
