package view.dialog;

import javax.swing.JOptionPane;

public class Dialog {
	public static void openDialog(String type) {
		switch(type.toLowerCase().trim()) {
		case "artista":
			JOptionPane.showMessageDialog(null, "Cadastre um artista primeiro!", null, 
					JOptionPane.ERROR_MESSAGE);
			break;
		case "musica":
			JOptionPane.showMessageDialog(null, "Cadastre uma música primeiro!", null, 
					JOptionPane.ERROR_MESSAGE);
			break;
		case "ouvinte":
			JOptionPane.showMessageDialog(null, "Cadastre um ouvinte primeiro!", null, 
					JOptionPane.ERROR_MESSAGE);	
			break;
		case "playlist":
			JOptionPane.showMessageDialog(null, "Cadastre uma playlist primeiro!", null, 
					JOptionPane.ERROR_MESSAGE);			
			break;
		case "artista_musica":
			JOptionPane.showMessageDialog(null, "Cadastre uma música e um artista primeiro!", null, 
					JOptionPane.ERROR_MESSAGE);			
			break;
		case "success":
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);			
			break;
		case "artista_repetido":
			JOptionPane.showMessageDialog(null, "Artista já pertence a música!", null, 
					JOptionPane.ERROR_MESSAGE);
			break;
		case "playlist_not_null":
			JOptionPane.showMessageDialog(null, "Playlist possui músicas cadastradas, remova elas para excluir a playlist!", null, 
					JOptionPane.ERROR_MESSAGE);
			break;
		case "musica_sem_artista":
			JOptionPane.showMessageDialog(null, "Música não pode ficar sem artista cadastrado!", null, 
					JOptionPane.ERROR_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Falha ao realizar a operação!", null, 
					JOptionPane.ERROR_MESSAGE);		
		}
	}
}
