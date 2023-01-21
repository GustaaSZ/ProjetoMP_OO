package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJLabel extends JLabel {
    public MyJLabel(String text) {
        super(text);
        setForeground(AesthethicsView.getCorLetra());
        setBackground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonte());
    }
}

