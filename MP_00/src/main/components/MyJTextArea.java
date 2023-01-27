package main.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJTextArea, herda elementos da classe JTextArea.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJTextArea extends JTextArea {

    /**
     * Construtor da classe MyJTextArea.
     * Altera as cores do background, foreground e altera a fonte de texto. 
     */
    public MyJTextArea() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setBackground(AesthethicsView.getCorFundo());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}
