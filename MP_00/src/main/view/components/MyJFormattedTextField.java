package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 * Classe MyJFormattedTextField, herda elementos da classe JFormattedTextField.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJFormattedTextField extends JFormattedTextField {

    /**
     * Construtor da classe MyJFormattedTextField.
     * Altera as cores do background, foreground e altera a fonte do texto. 
     * @param maskFormatter
     */
    public MyJFormattedTextField(MaskFormatter maskFormatter) {
        super(maskFormatter);
        setBackground(AesthethicsView.getCorFundoBtn());
        setForeground(AesthethicsView.getCorLetra());
        setFont(AesthethicsView.getFonteMenor());
    }
}
