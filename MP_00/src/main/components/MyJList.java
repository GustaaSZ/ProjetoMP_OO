package main.components;

import main.util.AesthethicsView;

import javax.swing.*;

/**
 * Classe MyJList, herda elementos da classe JList.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJList<T> extends JList {

    /**
     * Construtor da classe MyJList.
     * Altera as cores do background, foreground e altera a fonte do texto
       para padrões de fonte e cor definidos na classe AesthethicsView.
     *
     * @param model modelo da lista
     */
    public MyJList(DefaultListModel<T> model) {
        super(model);
        setBackground(AesthethicsView.getCorFundo());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}