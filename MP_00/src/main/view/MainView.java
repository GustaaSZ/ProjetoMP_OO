package main.view;

import main.view.artistas.ArtistasView;
import main.view.musicas.MusicasView;
import main.view.ouvintes.OuvintesView;
import main.view.playlists.PlaylistsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Artista.artistasCadastrados;
import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class MainView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	
	private JButton btnArtistas;
	private JButton btnMusicas;
	private JButton btnPlaylists;
	private JButton btnOuvintes;
	private JButton btnFechar;
	
//	CORES
Font fonte = new Font("Courier New", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);

// ----- Cinza escuro -------
Color corFundoBtn = new Color(54, 54, 54);

// ------- Verde forte ---------
Color fonteLetra = new Color(50, 205, 50);

// ---- Preto escuro ------
Color corFundo = new Color(28 ,28 ,28);

// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
   // a imagem que coloquei no mesmo pacote da main View

ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
JLabel label = new JLabel(imag);


	public MainView() {
		inicializar(this, "Sistema de Músicas", getPnlTitle(), getPnlBody(), getPnlRodape());

		btnArtistas.addActionListener(this);
		btnMusicas.addActionListener(this);
		btnPlaylists.addActionListener(this);
		btnOuvintes.addActionListener(this);
		btnFechar.addActionListener(this);
	}

	public JPanel getPnlTitle() {

    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Projeto Orientação à Objetos");

		//    	Mudando a cor da letra
		lblTitle.setForeground(fonteLetra);

    	pnlTitle.add(lblTitle);

		//		Mudando a cor do btn
    	pnlTitle.setBackground(corFundo);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnMusicas = new JButton("Gerenciar Musicas");
    	btnArtistas = new JButton("Gerenciar Artistas");
    	btnOuvintes = new JButton("Gerenciar Ouvintes");
    	btnPlaylists = new JButton("Gerenciar Playlists");
    	
		//    	Mudando as cores dos botões
		btnMusicas.setBackground(corFundoBtn);
		btnArtistas.setBackground(corFundoBtn);
		btnOuvintes.setBackground(corFundoBtn);
		btnPlaylists.setBackground(corFundoBtn);

		//    	Mudando as cores das Letra
		btnMusicas.setForeground(fonteLetra);
		btnArtistas.setForeground(fonteLetra);
		btnOuvintes.setForeground(fonteLetra);
		btnPlaylists.setForeground(fonteLetra);

    	pnlBody.add(btnArtistas);
    	pnlBody.add(btnMusicas);
    	pnlBody.add(btnOuvintes);
    	pnlBody.add(btnPlaylists);
    	
		// Adicionando ao pnlBody a imagem com o fundo Preto
    	pnlBody.add(label);
    	pnlBody.setBackground(corFundo);

		return pnlBody;
	}

    public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnFechar = new JButton("Fechar Programa");
		
		//	Mudando a cor da letra
		btnFechar.setForeground(corFundoBtn);
		btnFechar.setBackground(fonteLetra);

    	pnlRodape.add(btnFechar);
		
		//    	Mudando a cor de fundo do rodapé
    	pnlRodape.setBackground(corFundo);

		return pnlRodape;
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnArtistas) {
			this.dispose();
			new ArtistasView();
		}
		
		if (src == btnMusicas) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new MusicasView();	
		}
		
		if (src == btnOuvintes) {
			this.dispose();
			new OuvintesView();
		}
		
		if (src == btnPlaylists) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new PlaylistsView();
		}
		
		if (src == btnFechar) {
			System.exit(0);
		}
	}

}
