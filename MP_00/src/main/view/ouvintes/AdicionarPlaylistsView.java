package main.view.ouvintes;

import main.controller.OuvinteController;
import main.model.Ouvinte;
import main.model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;

public class AdicionarPlaylistsView extends JFrame implements ActionListener {
	
	// Instãnciando componenstes da Classe JPanel
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	// Instãnciando componenstes da Classe JLabel
	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblOuvinte;

	// Instãnciando componenstes da Classe JComboBox
	private JComboBox<Playlist> cboxPlaylist;
	private JComboBox<Ouvinte> cboxOuvinte;

	// Instãnciando componenstes da Classe JButton
	private JButton btnAdd;
	private JButton btnCancelar;

	// Construtor
	public AdicionarPlaylistsView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
//	---------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Adicionar Playlist");
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

		Playlist[] array = new Playlist[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i);
		}
		cboxPlaylist = new JComboBox<>(array);
		
		Ouvinte[] arrayOuvinte = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < arrayOuvinte.length; i++) {
			arrayOuvinte[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(arrayOuvinte);


		pnlForm.add(lblPlaylist);
		pnlForm.add(cboxPlaylist);
		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		

		return pnlForm;
	}
	
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Adicionar");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}
	
//	---------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
			if (!controller.adicionarPlaylist((Playlist) cboxPlaylist.getSelectedItem())) {
				JOptionPane.showMessageDialog(null, "Playlist já pertence a Ouvinte!");
				return;
			}
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Playlist adicionada com Sucesso!");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
}
