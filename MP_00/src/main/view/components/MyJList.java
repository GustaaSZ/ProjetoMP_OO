package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJList<T> extends JList {
    public MyJList(DefaultListModel<T> model) {
        super(model);
        setBackground(AesthethicsView.getCorFundo());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}
