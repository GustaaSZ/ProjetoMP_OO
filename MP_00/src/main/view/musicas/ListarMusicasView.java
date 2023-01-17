package main.view.musicas;

import main.model.Musica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;

public class ListarMusicasView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Musica> lista;
	
	private JButton btnVoltar;

	public ListarMusicasView(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Lista de Musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	DefaultListModel<Musica> model = new DefaultListModel<Musica>();
    	lista = new JList<Musica>(model);

    	for (int i = 0; i < musicasCadastradas.size(); i++) {
    	    model.add(i, musicasCadastradas.get(i));
		}
    	
		scroll = new JScrollPane(lista);

		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JViewport viewport = scroll.getViewport();
            int w = 400;
            int h = viewport.getPreferredSize().height;
            Dimension preferredSize = new Dimension(w, h);
            viewport.setPreferredSize(preferredSize);

    	pnlForm.add(scroll);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	
    	pnlRodape.add(btnVoltar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnVoltar) {
			this.dispose();
			new MusicasView();
		}
	}
	
}
