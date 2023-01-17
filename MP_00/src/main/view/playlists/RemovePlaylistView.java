package main.view.playlists;

import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.controller.PlaylistController.removerPlaylist;
import static main.model.Playlist.playlistsCadastradas;
import static main.view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.model.Playlist;

public class RemovePlaylistView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<String> cboxPlaylist;

	private JButton btnRemover;
	private JButton btnCancelar;

	public RemovePlaylistView() {
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Playlist");
		setSize(600, 400);
       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblArtista = new JLabel("Playlist:");

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		cboxPlaylist = new JComboBox<>(array);

		pnlForm.add(lblArtista);
		pnlForm.add(cboxPlaylist);

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {

			
			Playlist playlistSelecionada = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
			
			if (!removerPlaylist(playlistSelecionada)) {
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
