package main.app;

import main.view.TelaPrincipal;

import javax.swing.*;

 import static main.controller.Instanciacao.instanciar;

/**
 * Classe com método main.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Run {

    public static void main(String[] args) {
        instanciar();
        SwingUtilities.invokeLater(TelaPrincipal::new);
    }
}
