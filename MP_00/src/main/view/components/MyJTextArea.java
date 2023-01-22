package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJTextArea extends JTextArea {
    public MyJTextArea() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setBackground(AesthethicsView.getCorFundo());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}
