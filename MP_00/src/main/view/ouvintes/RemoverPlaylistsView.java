package main.view.ouvintes;

import main.controller.OuvinteController;
import main.model.Ouvinte;
import main.model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class RemoverPlaylistsView extends JFrame implements ActionListener {

	// Instãnciando componenstes da Classe JPanel
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	// Instãnciando componenstes da Classe JLabel
	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblOuvinte;

	// Instãnciando componenstes da Classe JComboBox
	private JComboBox<String> cboxPlaylist;
	private JComboBox<Ouvinte> cboxOuvinte;

	// Instãnciando componenstes da Classe JButton
	private JButton btnRemover;
	private JButton btnCancelar;

	// Construtor
	public RemoverPlaylistsView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
//	---------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}

		lblPlaylist = new JLabel("Playlist:");
		lblOuvinte = new JLabel("Ouvinte:");

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		cboxPlaylist = new JComboBox<>(array);
		
		Ouvinte[] arrayOuvinte = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < arrayOuvinte.length; i++) {
			arrayOuvinte[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(arrayOuvinte);

		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		pnlForm.add(lblPlaylist);
		pnlForm.add(cboxPlaylist);

		cboxOuvinte.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxPlaylist.removeAllItems();

				Ouvinte selected = (Ouvinte) cboxOuvinte.getSelectedItem();
				Playlist[] array1 = new Playlist[selected.getPlaylists().size()];
				for (int i = 0; i < array1.length; i++) {
					cboxPlaylist.addItem(selected.getPlaylists().get(i).getNome());
				}
			}
		});

		return pnlForm;
	}
	
	
//	---------------------------------------------------------------------------
	
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
	
//	---------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
			if (!controller.removerPlaylist(
					buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
				openDialog("error");
				return;
			}
			this.dispose();
			new OuvintesView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
}
