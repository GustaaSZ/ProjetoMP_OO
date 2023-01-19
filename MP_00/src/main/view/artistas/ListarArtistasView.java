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

	//	CORES
	Font fonte = new Font("Courier New", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);

	// ----- Cinza escuro -------
	Color corFundoBtn = new Color(54, 54, 54);

	// ------- Verde forte ---------
	Color fonteLetra = new Color(50, 205, 50);

	// ---- Preto escuro ------
	Color corFundo = new Color(28 ,28 ,28);

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote das Views.

	ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
	JLabel label = new JLabel(imag);

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
		lblTitle.setForeground(fonteLetra);


    	pnlTitle.add(lblTitle);
    	pnlTitle.setBackground(corFundo);
    	pnlTitle.add(label);

		return pnlTitle;
	}
	
//	-------------------------------------------------------------

	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	
    	DefaultListModel<Artista> model = new DefaultListModel<Artista>();
    	lista = new JList<Artista>(model);
		lista.setBackground(corFundo);
    	lista.setForeground(fonteLetra);

    	for (int i = 0; i < artistasCadastrados.size(); i++) {
    	    model.add(i, artistasCadastrados.get(i));
    	}
    	
    	scroll = new JScrollPane(lista);
    	
    	pnlForm.add(scroll);
    	pnlForm.add(label);
    	pnlForm.setBackground(corFundo);

		return pnlForm;
	}
	
//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	btnVoltar.setForeground(corFundo);
		btnVoltar.setBackground(fonteLetra);
		
		
    	pnlRodape.add(btnVoltar);
		pnlRodape.setBackground(corFundo);
		
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
