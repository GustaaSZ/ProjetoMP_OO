package main.view.playlists;

import javax.swing.*;

import static main.util.AesthethicsView.*;
import static main.util.AesthethicsView.getCorLetra;

/**
 * Classe Dialog que se relaciona com todas as telas das playlists.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class DialogPlaylists {

    /**
     * Método openDialog. Nele será usado um switch, para cada caso contém as mensagens de Warnings
     * Essa classe estará diretamente ligada com a captura de eventos das classes das views de playlists
     * @param type, do tipo String
     * Método void, portanto não tem nenhum tipo de retorno
     */
    public static void openDialog(String type) {
        setColor();
        switch (type.toLowerCase().trim()) {
            case "musica" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre uma música primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "playlist" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre uma playlist primeiro!",
                            null,
                            JOptionPane.ERROR_MESSAGE);
            case "success" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Operação realizada com sucesso!",
                            "Sucesso!",
                            JOptionPane.INFORMATION_MESSAGE);
            case "playlist_not_null" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Playlist possui músicas cadastradas," +
                                    " remova elas para excluir a playlist!",
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
            default ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Falha ao realizar a operação!",
                            "Erro!",
                            JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método setColor. Nele é alterado as cores de background e de fonte.
     * Método void, portanto não tem nenhum tipo de retorno.
     */
    private static void setColor(){
        UIManager.put("Panel.background",getCorFundo());
        UIManager.put("OptionPane.background", getCorFundoBtn());
        UIManager.put("OptionPane.buttonFont", getFonteMenor());
        UIManager.put("OptionPane.messageForeground", getCorLetra());
        UIManager.put("Button.background", getCorLetra());
    }
}
