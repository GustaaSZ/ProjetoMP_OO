package main.view.artistas;

import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Artista.artistasCadastrados;
import static main.util.Inicializacao.inicializar;
import main.util.AesthethicsView;

public class ListarArtistasView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Artista> lista;
	
	private JButton btnVoltar;

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote das Views.

	//ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	//JLabel label = new JLabel(imag);

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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());


    	pnlTitle.add(lblTitle);
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	// pnlTitle.add(label);

		return pnlTitle;
	}
	
//	-------------------------------------------------------------

	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	
    	DefaultListModel<Artista> model = new DefaultListModel<Artista>();
    	lista = new JList<Artista>(model);
		lista.setBackground(AesthethicsView.getCorFundo());
    	lista.setForeground(AesthethicsView.getCorLetra());
		lista.setFont(AesthethicsView.getFonteMenor());

    	for (int i = 0; i < artistasCadastrados.size(); i++) {
    	    model.add(i, artistasCadastrados.get(i));
    	}
    	
    	scroll = new JScrollPane(lista);
    	
    	pnlForm.add(scroll);
    	// pnlForm.add(label);
    	pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}
	
//	-------------------------------------------------------------

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
