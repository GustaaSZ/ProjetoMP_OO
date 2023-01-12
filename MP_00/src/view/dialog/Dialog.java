package view.dialog;

import javax.swing.JOptionPane;

public class Dialog {
	public static void openDialog(String type) {
		switch(type.toLowerCase().trim()) {
		case "artista":
			JOptionPane.showMessageDialog(null, "Cadastre um artista primeiro!");
			break;
		case "musica":
			JOptionPane.showMessageDialog(null, "Cadastre uma música primeiro!");
			break;
		case "ouvinte":
			JOptionPane.showMessageDialog(null, "Cadastre um ouvinte primeiro!");	
			break;
		case "playlist":
			JOptionPane.showMessageDialog(null, "Cadastre uma playlist primeiro!");			
			break;
		case "artista_musica":
			JOptionPane.showMessageDialog(null, "Cadastre uma música e um artista primeiro!");			
			break;
		case "success":
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");			
			break;
		case "artista_repetido":
			JOptionPane.showMessageDialog(null, "Artista já pertence a música!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Falha ao realizar a operação!");		
		}
	}
}
