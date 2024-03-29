package main.view.artistas;


import main.model.Artista;

import javax.swing.*;

import static main.util.AesthethicsView.*;
import static main.util.AesthethicsView.getCorLetra;

/**
 * Classe Dialog que se relaciona com todas as telas dos artistas.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class DialogArtistas {

    /**
     * Método openDialog. Nele será usado um switch, para cada caso contém as mensagens de Warnings.
     * Essa classe estará diretamente ligada com a captura de eventos das classes das views de artista
     *  @param type, do tipo String
     * Método void, portanto não tem nenhum tipo de retorno
     */
    public static void openDialog(String type) {
        setColor();
        switch (type.toLowerCase().trim()) {
            case "artista" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Cadastre um artista primeiro!",
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
            case "artista_nao_encontrado" ->
                    JOptionPane.showMessageDialog(
                            null,
                            "Artista não encontradado",
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
     * Método objetoEncontrado. Nele contém para as mensagens de Warnings caso um artista seja encontrado
     * @param o do tipo object
     * Retorna TRUE, caso os objects seja encontrado e FALSE caso contrário.
     * @return boolean
     */
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
        return false;
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