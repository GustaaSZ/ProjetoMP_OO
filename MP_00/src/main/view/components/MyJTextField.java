package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJTextField, herda elementos da classe JTextField.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJTextField extends JTextField {

    /**
     * Construtor da classe MyJTextField.
     * Altera as cores do background, foreground e altera a fonte de texto.
     * @param columns 
     */
    public MyJTextField(int columns) {
        super(columns);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}

