package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJButton, herda elementos da classe JButton.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJButton extends JButton {

    /**
     * Construtor da classe MyJButton.
     * Altera as cores do background e foreground. Além de alterar a fonte do texto. 
     * @version 1.0
     * @param text
     */
    public MyJButton(String text) {
        super(text);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonte());
    }

    /**
     * Construtor da classe MyJButton.
     * Altera as cores do background e foreground. Além de alterar a fonte do texto. 
     * @version 1.1
     * @param text e isRodape
     */
    public MyJButton(String text, boolean isRodape) {
        super(text);
        setBackground(AesthethicsView.getCorLetra());
        setForeground(AesthethicsView.getCorFundoBtn());
        setFont(AesthethicsView.getFonteMenor());
    }
}

