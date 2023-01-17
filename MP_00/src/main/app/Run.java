package main.app;

import javax.swing.SwingUtilities;
import static main.util.Instanciacao.instanciar;

import main.view.MainView;

public class Run {

	public static void main(String[] args) {
		instanciar();
		SwingUtilities.invokeLater(MainView::new);
	}
}
