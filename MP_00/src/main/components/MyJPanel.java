package main.components;

import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;

/**
 * Classe MyJPanel, herda elementos da classe JPanel.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MyJPanel extends JPanel {

    /**
     * Construtor da classe MyJPanel.
     * Altera as cores do background.
     * @param flowLayout layout do panel
     */
    public MyJPanel(FlowLayout flowLayout) { //  Panel para o Header e Footer 
        super(flowLayout);
        setBackground(AesthethicsView.getCorFundoBtn());
    }

    /**
     * Construtor da classe MyJPanel.
     * Altera as cores do background.
     * @param flowLayout layout do panel
     * @param isForm se o panel é um form
     */
    public MyJPanel(FlowLayout flowLayout, boolean isForm) { // Panels para o Body
        super(flowLayout);
        setBackground(AesthethicsView.getCorFundo());
    }

    /**
     * Construtor da classe MyJPanel.
     * Altera as cores do background.
     * @param gridLayout layout do panel
     */
    public MyJPanel(GridLayout gridLayout) {
        super(gridLayout);
        setBackground(AesthethicsView.getCorFundo());
    }

    /**
     * Construtor da classe MyJPanel.
     * Altera as cores do background.
     * @param borderLayout layout do panel
     */
    public MyJPanel(BorderLayout borderLayout) {
        super(borderLayout);
        setBackground(AesthethicsView.getCorFundo());
    }
}
