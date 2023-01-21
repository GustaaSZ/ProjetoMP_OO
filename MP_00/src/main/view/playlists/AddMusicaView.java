package main.view.playlists;

import main.controller.PlaylistController;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AddMusicaView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJComboBox<String> cboxPlaylist;
	private MyJComboBox<String> cboxMusica;

	private MyJButton btnAdd;
	private MyJButton btnCancelar;

	public AddMusicaView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		MyJLabel lblTitle = new MyJLabel("Adicionar Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(2, 2), true);
		}
		MyJLabel lblPlaylist = new MyJLabel("Playlist:");
		cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

		MyJLabel lblMusica = new MyJLabel("Música:");
		cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblMusica);
    	pnlForm.add(cboxMusica);

		return pnlForm;
	}

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnAdd = new MyJButton("Adicionar", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {

			PlaylistController controller = new PlaylistController(
				buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())
				);
			
			if (!controller.adicionarMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
				openDialog("error");
				return;
			}
			
			this.dispose();
			new PlaylistsView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new PlaylistsView();
		}
	}
}
