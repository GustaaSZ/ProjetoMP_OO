package main.view.playlists;

import main.model.Playlist;
import main.util.AesthethicsView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJList;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;

public class ListarPlaylistsView extends JFrame implements ActionListener{

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJButton btnVoltar;

	public ListarPlaylistsView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
		MyJLabel lblTitle = new MyJLabel("Lista de playlists");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	public MyJPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
    	}
		DefaultListModel<Playlist> model = new DefaultListModel<>();
		MyJList<Playlist> lista = new MyJList<>(model);

    	for (int i = 0; i < playlistsCadastradas.size(); i++) {
    	    model.add(i, playlistsCadastradas.get(i));
    	}

		JScrollPane scroll = new JScrollPane(lista);
		scroll.setBackground(AesthethicsView.getCorFundo());
    	
    	pnlForm.add(scroll);

		return pnlForm;
	}
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnVoltar = new MyJButton("Voltar");
    	pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnVoltar) {
			this.dispose();
			new PlaylistsView();
		}
	}
	
}
