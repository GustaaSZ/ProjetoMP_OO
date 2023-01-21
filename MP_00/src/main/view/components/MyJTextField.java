package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;

public class MyJTextField extends JTextField {
    public MyJTextField(int columns) {
        super(columns);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}

