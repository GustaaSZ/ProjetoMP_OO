package main.view.artistas;

import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Artista.artistasCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarArtistasView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Artista> lista;
	
	private JButton btnVoltar;

	public ListarArtistasView(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnVoltar.addActionListener(this);
	}
	
	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Lista de Artistas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	-------------------------------------------------------------

	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	
    	DefaultListModel<Artista> model = new DefaultListModel<Artista>();
    	lista = new JList<Artista>(model);

    	for (int i = 0; i < artistasCadastrados.size(); i++) {
    	    model.add(i, artistasCadastrados.get(i));
    	}
    	
    	scroll = new JScrollPane(lista);
    	
    	pnlForm.add(scroll);
    	
		return pnlForm;
	}
	
//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	
    	pnlRodape.add(btnVoltar);
		
		return pnlRodape;
	}

//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnVoltar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
