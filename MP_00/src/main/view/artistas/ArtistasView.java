package main.view.artistas;


import main.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Color;

import static main.model.Artista.artistasCadastrados;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class ArtistasView extends JFrame implements ActionListener{
	
	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnListMusicas;
	private JButton btnBuscar;
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
	// a imagem que coloquei no mesmo pacote da main View

	ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
	JLabel label = new JLabel(imag);


	public ArtistasView() {
		inicializar(this, "CRUD Artistas", getPnlTitle(), getPnlBody(), getPnlRodape());

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnListMusicas.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnVoltar.addActionListener(this);
	}

// ---------------------------------------------------------------
    
	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Crud de Artistas");

		// Mudando a cor do lblTitle
		lblTitle.setForeground(fonteLetra);

		pnlTitle.add(lblTitle);

		// Mudando a cor de fundo do pnlTitle
		pnlTitle.setBackground(corFundo);

		return pnlTitle;
	}

 // ---------------------------------------------------------------
    
	public JPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Cadastrar Artista");
		btnRemove = new JButton("Remover Artista");
		btnUpdate = new JButton("Atualizar Artista");
		btnList = new JButton("Listar Artistas");
		btnBuscar = new JButton("Buscar Artista");
		btnListMusicas = new JButton("Listar Músicas do Artista");

		// Mudando as cores das letras dos botões
		btnAdd.setForeground(fonteLetra);
		btnRemove.setForeground(fonteLetra);
		btnUpdate.setForeground(fonteLetra);
		btnList.setForeground(fonteLetra);
		btnListMusicas.setForeground(fonteLetra);

		// Mudando as cores de fundo dos botões
		btnAdd.setBackground(corFundoBtn);
		btnRemove.setBackground(corFundoBtn);
		btnUpdate.setBackground(corFundoBtn);
		btnList.setBackground(corFundoBtn);
		btnListMusicas.setBackground(corFundoBtn);


		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnBuscar);
		pnlBody.add(btnListMusicas);

		// Add a imagem de fundo preto ao pnlBody
		pnlBody.add(label);
		pnlBody.setBackground(corFundo);


		return pnlBody;
	}

// ---------------------------------------------------------------
	
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
	
// ---------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			this.dispose();
			new AddArtistasView();
		}

		if (src == btnRemove) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new RemoveArtistaView();
		}

		if (src == btnUpdate) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new UpdateArtistaView();
		}

		if (src == btnList) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new ListarArtistasView();
		}

		if (src == btnBuscar) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new BuscarArtista();
		}
		
		if (src == btnListMusicas) {
			if (musicasCadastradas.isEmpty() || artistasCadastrados.isEmpty()) {
				openDialog("artista_musica");
				return;
			}
			this.dispose();
			new ListarMusicasArtistaView();
		}

		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
	}


}
