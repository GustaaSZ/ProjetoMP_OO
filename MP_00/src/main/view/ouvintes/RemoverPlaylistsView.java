package main.view.ouvintes;

import main.controller.OuvinteController;
import main.model.Ouvinte;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.arrayPlaylistsPorOuvinte;
import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoverPlaylistsView extends JFrame implements ActionListener {

	// Instãnciando componenstes da Classe MyJPanel
	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJComboBox<String> cboxPlaylist;
	private MyJComboBox<String> cboxOuvinte;

	private MyJButton btnRemover;
	private MyJButton btnCancelar;

	// Construtor
	public RemoverPlaylistsView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
//	---------------------------------------------------------------------------
	
	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		// Instãnciando componenstes da Classe MyJLabel
		MyJLabel lblTitle = new MyJLabel("Remover Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
//	---------------------------------------------------------------------------
	
	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(2, 2));
		}
		MyJLabel lblPlaylist = new MyJLabel("Playlist:");
		MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");

		cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());
		cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		pnlForm.add(lblPlaylist);
		pnlForm.add(cboxPlaylist);

		cboxOuvinte.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxPlaylist.removeAllItems();

				var array = arrayPlaylistsPorOuvinte(buscarOuvintePorNome(
	            		(String) cboxOuvinte.getSelectedItem()));
				for (int i = 0; i < array.length; i++) {
					cboxPlaylist.addItem(
							buscarOuvintePorNome(
			                		(String) cboxOuvinte.getSelectedItem()).getPlaylists().get(i).getNome());
				}
			}
		});

		return pnlForm;
	}
	
	
//	---------------------------------------------------------------------------
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnRemover = new MyJButton("Remover", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}
	
//	---------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			OuvinteController controller = new OuvinteController(buscarOuvintePorNome(
            		(String) cboxOuvinte.getSelectedItem()));
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
