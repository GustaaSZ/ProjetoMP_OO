package main.view.ouvintes;

import main.model.Ouvinte;
import main.model.Playlist;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarPlaylistsOuvinteView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblOuvinte;

	private JComboBox<Ouvinte> cboxOuvinte;

	private JList<Playlist> lista;

	private JButton btnVoltar;

	public ListarPlaylistsOuvinteView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}


	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Lista de Playlists do Ouvinte");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
		
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblOuvinte = new JLabel("Ouvinte:");
		lblOuvinte.setForeground(AesthethicsView.getCorLetra());
		lblOuvinte.setFont(AesthethicsView.getFonte());
		
		pnlForm.add(lblOuvinte, BorderLayout.NORTH);
		
		Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(array);
		cboxOuvinte.setForeground(AesthethicsView.getCorLetra());
		cboxOuvinte.setBackground(AesthethicsView.getCorFundoBtn());
		cboxOuvinte.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(cboxOuvinte, BorderLayout.NORTH);

		DefaultListModel<Playlist> model = new DefaultListModel<Playlist>();
		lista = new JList<Playlist>(model);
		lista.setForeground(AesthethicsView.getCorLetra());
		lista.setBackground(AesthethicsView.getCorFundo());
		lista.setFont(AesthethicsView.getFonteMenor());

		Ouvinte selected = (Ouvinte) cboxOuvinte.getSelectedItem();

		for (int i = 0; i < selected.getPlaylists().size(); i++) {
			model.add(i, selected.getPlaylists().get(i));
		}
		
		pnlForm.add(lista, BorderLayout.CENTER);
		pnlForm.setBackground(AesthethicsView.getCorFundo());
		
		
		cboxOuvinte.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Ouvinte selected1 = (Ouvinte) cboxOuvinte.getSelectedItem();
				Playlist[] playlists = selected1.getPlaylists().toArray(new Playlist[selected1.getPlaylists().size()]);
				lista.setListData(playlists);
			}
		});
		return pnlForm;
		
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnVoltar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
}
