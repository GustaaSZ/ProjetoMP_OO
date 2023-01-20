package main.view.playlists;

import main.model.Musica;
import main.model.Playlist;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class MusicasView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JScrollPane scroll;

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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
		
		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblPlaylist = new JLabel("Playlist:");
		lblPlaylist.setForeground(AesthethicsView.getCorLetra());
		lblPlaylist.setFont(AesthethicsView.getFonte());
		
		pnlForm.add(lblPlaylist, BorderLayout.NORTH);

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		cboxPlaylist = new JComboBox<>(array);
		cboxPlaylist.setForeground(AesthethicsView.getCorLetra());
		cboxPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
		cboxPlaylist.setFont(AesthethicsView.getFonteMenor());
		
		pnlForm.add(cboxPlaylist, BorderLayout.NORTH);

		Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
		
		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);
		lista.setForeground(AesthethicsView.getCorLetra());
		lista.setBackground(AesthethicsView.getCorFundo());
		lista.setFont(AesthethicsView.getFonteMenor());

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}

		scroll = new JScrollPane(lista);

		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBackground(AesthethicsView.getCorFundo());

		pnlForm.add(scroll);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

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
		btnVoltar.setForeground(AesthethicsView.getCorFundo());
		btnVoltar.setBackground(AesthethicsView.getCorLetra());
		btnVoltar.setFont(AesthethicsView.getFonte());
		

		pnlRodape.add(btnVoltar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

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
