package main.view.playlists;

import main.model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.util.AesthethicsView;

import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;

public class ListarPlaylistsView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Playlist> lista;
	
	private JButton btnVoltar;

	public ListarPlaylistsView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Lista de playlists");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

		DefaultListModel<Playlist> model = new DefaultListModel<Playlist>();
    	lista = new JList<Playlist>(model);
		lista.setForeground(AesthethicsView.getCorLetra());
		lista.setBackground(AesthethicsView.getCorFundo());
		lista.setFont(AesthethicsView.getFonteMenor());

    	for (int i = 0; i < playlistsCadastradas.size(); i++) {
    	    model.add(i, playlistsCadastradas.get(i));
    	}
    	
    	scroll = new JScrollPane(lista);
		scroll.setBackground(AesthethicsView.getCorFundo());
    	
    	pnlForm.add(scroll);
		pnlForm.setBackground(AesthethicsView.getCorFundo());
    	
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
			new PlaylistsView();
		}
	}
	
}
