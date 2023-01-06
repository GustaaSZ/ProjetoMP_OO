package app;

import javax.swing.SwingUtilities;

import view.MainView;

public class Run {

	public static void main(String[] args) {
	      SwingUtilities.invokeLater(() -> {
	    	  new MainView();
	        });
	}
}
