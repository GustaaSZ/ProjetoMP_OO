package main.view.playlists;

import main.controller.PlaylistController;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class UpdatePlaylistView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJLabel lblPlaylist;
	private MyJLabel lblTitle;
	private MyJLabel lblNome;
	private MyJLabel lblDescricao;
	
	private MyJTextField txtNome;
	private MyJTextField txtDescricao;
	
	private MyJComboBox<String> cboxPlaylist;

	private MyJButton btnUpdt;
	private MyJButton btnCancelar;

	public UpdatePlaylistView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		lblTitle = new MyJLabel("Atualizar Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(5, 2), true);
		}
		lblPlaylist = new MyJLabel("Playlist:");
		cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

		lblNome = new MyJLabel("Nome:");
    	txtNome = new MyJTextField(15);
		txtNome.setText(playlistsCadastradas.get(0).getNome());
    	
    	lblDescricao = new MyJLabel("Descrição:");
    	txtDescricao = new MyJTextField(15);
		txtDescricao.setText(playlistsCadastradas.get(0).getDescricao());
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblDescricao);
    	pnlForm.add(txtDescricao);

		cboxPlaylist.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				var selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
				txtNome.setText(selected.getNome());
				txtDescricao.setText(selected.getDescricao());
				}
			});

		return pnlForm;
	}

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnUpdt = new MyJButton("Atualizar", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnUpdt);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnUpdt) {
			PlaylistController controller = new PlaylistController(
					buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()));
			controller.atualizarPlaylist(
					txtNome.getText(), 
					txtDescricao.getText()
			);
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
