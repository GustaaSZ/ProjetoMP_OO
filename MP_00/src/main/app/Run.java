package main.app;

import main.view.MainView;

import javax.swing.*;

import static main.util.Instanciacao.instanciar;

public class Run {

    public static void main(String[] args) {
        instanciar();
        SwingUtilities.invokeLater(MainView::new);
    }
}
