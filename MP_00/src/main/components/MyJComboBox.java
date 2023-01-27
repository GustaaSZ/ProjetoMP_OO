package main.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJComboBox, herda elementos da classe JComboBox.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJComboBox<T> extends JComboBox {

    /**
     * Construtor da classe MyJComboBox.
     * Altera as cores do background, foreground e altera a fonte do texto. 
     * @param items lista de itens do JComboBox
     */
    public MyJComboBox(T[] items) {
        super(items);
        setFont(AesthethicsView.getFonte());
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
    }
}
