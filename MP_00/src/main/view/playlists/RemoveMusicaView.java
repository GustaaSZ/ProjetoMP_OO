package main.view.playlists;

import main.controller.PlaylistController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class RemoveMusicaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblMusica;
	
	private JComboBox<String> cboxPlaylist;
	private JComboBox<String> cboxMusica;

	private JButton btnRmv;
	private JButton btnCancelar;

	public RemoveMusicaView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRmv.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Música de alguma Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}
		
		lblPlaylist = new JLabel("Playlist:");
		
		cboxPlaylist = new JComboBox<>(arrayPlaylistsCadastradas());

		lblMusica = new JLabel("Música:");

		cboxMusica = new JComboBox<>(arrayMusicasNaPlaylist(
				buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())));
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblMusica);
    	pnlForm.add(cboxMusica);

		cboxPlaylist.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxMusica.removeAllItems();

				var selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
				var array = arrayMusicasNaPlaylist(selected);

				for (int i = 0; i < array.length; i++) {
					cboxMusica.addItem(selected.getMusicas().get(i).getNome());
				}
			}
		});
		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRmv = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnRmv);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRmv) {

			PlaylistController controller = new PlaylistController(
				buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())
				);
			
			if (!controller.removerMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
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
