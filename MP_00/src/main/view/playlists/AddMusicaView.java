package main.view.playlists;

import main.controller.PlaylistController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import main.util.AesthethicsView;
import static main.view.dialog.Dialog.openDialog;

public class AddMusicaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblMusica;
	
	private JComboBox<String> cboxPlaylist;
	private JComboBox<String> cboxMusica;

	private JButton btnAdd;
	private JButton btnCancelar;

	public AddMusicaView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Adicionar Música");
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

		lblMusica = new JLabel("Música:");
		lblMusica.setForeground(AesthethicsView.getCorLetra());
		lblMusica.setFont(AesthethicsView.getFonte());
    	
		String[] arrayMusica = new String[musicasCadastradas.size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = musicasCadastradas.get(i).getNome();
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

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Adicionar");
		btnAdd.setForeground(AesthethicsView.getCorFundo());
		btnAdd.setBackground(AesthethicsView.getCorLetra());
		btnAdd.setFont(AesthethicsView.getFonte());


		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		
		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

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
