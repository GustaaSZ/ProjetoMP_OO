package app;

import javax.swing.SwingUtilities;
import static util.Instanciacao.instanciar;

import view.MainView;

public class Run {

	public static void main(String[] args) {
		instanciar();
		SwingUtilities.invokeLater(() -> {
			new MainView();
		});
	}
}
