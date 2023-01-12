package app;

import javax.swing.SwingUtilities;
import static util.Instanciacao.instanciar;

import view.MainView;

public class Run {

	public static void main(String[] args) {
		// Instanciando o método instanciar da classe Instnaciacao
		instanciar();
		SwingUtilities.invokeLater(() -> {
			new MainView();
		});
	}
}
