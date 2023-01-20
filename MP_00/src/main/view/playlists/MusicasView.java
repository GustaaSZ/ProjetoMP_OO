package main.view.playlists;

import main.model.Musica;
import main.model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class MusicasView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblPlaylist;

	private JList<Musica> lista;

	private JComboBox<String> cboxPlaylist;

	private JButton btnVoltar;

	public MusicasView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}

	//	-------------------------------------------------------------
	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Músicas da Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblPlaylist = new JLabel("Playlist:");
		
		pnlForm.add(lblPlaylist, BorderLayout.NORTH);

		cboxPlaylist = new JComboBox<>(arrayPlaylistsCadastradas());

		pnlForm.add(cboxPlaylist, BorderLayout.NORTH);

		Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
		
		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}

		pnlForm.add(lista, BorderLayout.CENTER);

		cboxPlaylist.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Playlist selected1 = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
				Musica[] musicas = selected1.getMusicas().toArray(new Musica[selected1.getMusicas().size()]);
				if (musicas.length > 0) {
					lista.setListData(musicas);
				} else {
					lista.setListData(musicas);
					openDialog("playlist_vazia");
				}
			}
		});
		return pnlForm;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnVoltar = new JButton("Voltar");

		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnVoltar) {
			this.dispose();
			new PlaylistsView();
		}
	}
}
