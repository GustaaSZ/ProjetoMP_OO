package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJComboBox<T> extends JComboBox {
    public MyJComboBox(T[] items) {
        super(items);
        setFont(AesthethicsView.getFonte());
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
    }
}

