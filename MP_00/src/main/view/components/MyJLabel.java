package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJLabel, herda elementos da classe JLabel.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJLabel extends JLabel {

    /**
     * Construtor da classe MyJLabel.
     * Altera as cores do background, foreground e altera a fonte do texto. 
     * @param text
     */
    public MyJLabel(String text) {
        // Chama o construtor da classe Pai (JLabel)
        super(text);
        setForeground(AesthethicsView.getCorLetra());
        setBackground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonte());
    }
}

