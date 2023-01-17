package main.util;

import javax.swing.*;
import java.awt.*;

public class Inicializacao {

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
