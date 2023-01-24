package main.util;

import javax.swing.*;
import java.awt.*;

/**
 * Classe com método para inicialização das telas.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class Inicializacao {

    /**
     * Método utilizado para inicializar as telas.
     * @param jFrame tela que será inicializada.
     * @param title título da tela.
     * @param titlePanel painel de título.
     * @param bodyPanel painel de corpo.
     * @param footerPanel painel de rodapé.
     */
    public static void inicializar(JFrame jFrame, String title, JPanel titlePanel, JPanel bodyPanel, JPanel footerPanel) {
        jFrame.setTitle(title);
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        jFrame.getContentPane().setLayout(new BorderLayout());
        jFrame.getContentPane().add(titlePanel, BorderLayout.PAGE_START);
        jFrame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
        jFrame.getContentPane().add(footerPanel, BorderLayout.PAGE_END);
    }
}
