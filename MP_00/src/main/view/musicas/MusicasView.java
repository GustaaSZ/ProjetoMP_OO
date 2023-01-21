package main.view.musicas;

import main.util.AesthethicsView;
import main.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;

import static main.view.dialog.Dialog.openDialog;

public class MusicasView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnVoltar;
	private JButton btnAddArt;
	private JButton btnRmvArt;
	private JButton btnLetra;
	
	public MusicasView() {
		
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlBody(), getPnlRodape());
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnAddArt.addActionListener(this);
		btnRmvArt.addActionListener(this);
		btnLetra.addActionListener(this);

	}

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	//ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	//JLabel label = new JLabel(imag);
	

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Crud de musicas");
	    // Mudando a cor da letra e a fonte
    	lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
		
		pnlTitle.add(lblTitle);

		// Mudando a cor de fundo do pnlTitle
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Cadastrar Musica");
		btnRemove = new JButton("Remover Musica");
		btnUpdate = new JButton("Atualizar Musica");
		btnList = new JButton("Listar Musicas");
		btnAddArt = new JButton("Adicionar artista na Música");
		btnRmvArt = new JButton("Remover artista da Música");
		btnLetra = new JButton("Ver letra da Música");

		// Mudando as cores das letras dos botões
		btnAdd.setForeground(AesthethicsView.getCorLetra());
		btnRemove.setForeground(AesthethicsView.getCorLetra());
		btnUpdate.setForeground(AesthethicsView.getCorLetra());
		btnList.setForeground(AesthethicsView.getCorLetra());
		btnAddArt.setForeground(AesthethicsView.getCorLetra());
		btnRmvArt.setForeground(AesthethicsView.getCorLetra());
		btnLetra.setForeground(AesthethicsView.getCorLetra());

		// Mudando as cores de fundo dos botões
		btnAdd.setBackground(AesthethicsView.getCorFundoBtn());
		btnRemove.setBackground(AesthethicsView.getCorFundoBtn());
		btnUpdate.setBackground(AesthethicsView.getCorFundoBtn());
		btnList.setBackground(AesthethicsView.getCorFundoBtn());
		btnAddArt.setBackground(AesthethicsView.getCorFundoBtn());
		btnRmvArt.setBackground(AesthethicsView.getCorFundoBtn());
		btnLetra.setBackground(AesthethicsView.getCorFundoBtn());

		// Mudando as fontes dos botões
		btnAdd.setFont(AesthethicsView.getFonteMenor());
		btnRemove.setFont(AesthethicsView.getFonteMenor());
		btnUpdate.setFont(AesthethicsView.getFonteMenor());
		btnList.setFont(AesthethicsView.getFonteMenor());
		btnAddArt.setFont(AesthethicsView.getFonteMenor());
		btnRmvArt.setFont(AesthethicsView.getFonteMenor());
		btnLetra.setFont(AesthethicsView.getFonteMenor());

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnLetra);
		pnlBody.add(btnAddArt);
		pnlBody.add(btnRmvArt);
		
		// Adicionando ao pnlBody a imagem com o fundo Preto
		//pnlBody.add(CoresView.getLabel());
		pnlBody.setBackground(AesthethicsView.getCorFundo());
		

		return pnlBody;
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

		if (src == btnAdd) {
			this.dispose();
			new AddMusicaView();
		}

		if (src == btnRemove) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new RemoveMusicaView();
		}

		if (src == btnUpdate) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new UpdateMusicaView();
		}

		if (src == btnList) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new ListarMusicasView();
		}
		
		if (src == btnAddArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new AdicionarArtistasView();
		}

		if (src == btnRmvArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new RemoverArtistaView();
		}

		if (src == btnLetra) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new LetraView();
		}

		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
	}
}
