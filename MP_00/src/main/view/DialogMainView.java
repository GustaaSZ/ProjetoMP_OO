package main.view;

// import main.model.Artista;
// import main.model.Ouvinte;

import javax.swing.*;

import static main.util.AesthethicsView.*;
import static main.util.AesthethicsView.getCorLetra;

/**
 * Classe DialogTelaPrincipal que se relaciona com a tela principal do sistema.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class DialogMainView {

        /**
         * Método openDialog. Nele será usado um switch, para cada caso contém as mensagens de Warnings.
         * Essa classe estará diretamente ligada com a captura de eventos da classe mainView.
         * @param type, do tipo String
         * Método void, portanto não tem nenhum tipo de retorno
         */
        public static void openDialog(String type) {
                setColor();
                switch (type.toLowerCase().trim()) {

                case "artista" -> JOptionPane.showMessageDialog(
                        null,
                        "Cadastre um artista primeiro!",
                        null,
                        JOptionPane.ERROR_MESSAGE);

                case "ouvinte" -> JOptionPane.showMessageDialog(
                        null,
                        "Cadastre um ouvinte primeiro!",
                        null,
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

