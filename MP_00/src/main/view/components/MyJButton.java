package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJButton extends JButton {
    public MyJButton(String text) {
        super(text);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonte());
    }

    public MyJButton(String text, boolean isRodape) {
        super(text);
        setBackground(AesthethicsView.getCorLetra());
        setForeground(AesthethicsView.getCorFundoBtn());
        setFont(AesthethicsView.getFonteMenor());
    }
}

