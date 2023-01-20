package main.view.playlists;

import javax.swing.*;

import main.util.AesthethicsView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.controller.PlaylistController.removerPlaylist;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class RemovePlaylistView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<String> cboxPlaylist;

	private JButton btnRemover;
	private JButton btnCancelar;

	public RemovePlaylistView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Playlist");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblArtista = new JLabel("Playlist:");
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setFont(AesthethicsView.getFonte());

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		cboxPlaylist = new JComboBox<>(array);
		cboxPlaylist.setForeground(AesthethicsView.getCorLetra());
		cboxPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
		cboxPlaylist.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(lblArtista);
		pnlForm.add(cboxPlaylist);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnRemover.setForeground(AesthethicsView.getCorFundo());
		btnRemover.setBackground(AesthethicsView.getCorLetra());
		btnRemover.setFont(AesthethicsView.getFonte());


		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {

			if (!removerPlaylist(buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
				openDialog("playlist_not_null");
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
