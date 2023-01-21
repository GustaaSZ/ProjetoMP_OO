package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class MyJFormattedTextField extends JFormattedTextField {
    public MyJFormattedTextField(MaskFormatter maskFormatter) {
        super(maskFormatter);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}
