package main.view.playlists;

import main.controller.PlaylistController;
import main.model.Musica;
import main.model.Playlist;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Playlist.playlistsCadastradas;
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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}
		
		lblPlaylist = new JLabel("Playlist:");
		lblPlaylist.setForeground(AesthethicsView.getCorLetra());
		lblPlaylist.setFont(AesthethicsView.getFonte());

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}

		cboxPlaylist = new JComboBox<>(array);
		cboxPlaylist.setForeground(AesthethicsView.getCorLetra());
		cboxPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
		cboxPlaylist.setFont(AesthethicsView.getFonteMenor());

		Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());

		lblMusica = new JLabel("Música:");
    	lblMusica.setForeground(AesthethicsView.getCorLetra());
		lblMusica.setFont(AesthethicsView.getFonte());

		String[] arrayMusica = new String[selected.getMusicas().size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = selected.getMusicas().get(i).getNome();
		}
		
		cboxMusica = new JComboBox<>(arrayMusica);
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundoBtn());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblMusica);
    	pnlForm.add(cboxMusica);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		cboxPlaylist.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxMusica.removeAllItems();

				Playlist selected1 = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
				Musica[] array1 = new Musica[selected1.getMusicas().size()];
				for (int i = 0; i < array1.length; i++) {
					cboxMusica.addItem(selected1.getMusicas().get(i).getNome());
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
		btnRmv.setForeground(AesthethicsView.getCorFundo());
		btnRmv.setBackground(AesthethicsView.getCorLetra());
		btnRmv.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnRmv);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

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
