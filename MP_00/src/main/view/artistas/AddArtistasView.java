package main.view.artistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Color;

import static main.controller.ArtistaController.cadastrarArtista;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class AddArtistasView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblNome;
	
	private JTextField txtNome;
	
	private JButton btnCriar;
	private JButton btnCancelar;

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

	public AddArtistasView(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}

    	lblTitle = new JLabel("Crud de Artistas");

		//    	Mudando a cor da letra
    	lblTitle.setForeground(fonteLetra);
    	
    	pnlTitle.add(lblTitle);

		//		Mudando a cor do btn
    	pnlTitle.setBackground(corFundo);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	lblNome = new JLabel("Nome:");
		// Mudando a cor do Jl=Label NNome
		lblNome.setForeground(fonteLetra);
		// Mudando a cor do fundo
    	lblNome.setBackground(corFundo);

    	txtNome = new JTextField(20);
		// Mudando a cor de fundo do JTxt
    	txtNome.setBackground(corFundoBtn);
		// Mudando a cor do texto que o usuário digitar
    	txtNome.setForeground(fonteLetra);


    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		// Adicionando a imagem7
    	pnlForm.add(label);
		// preenchendo as partes do body que não foram preenchidas com a cor de fundo
    	pnlForm.setBackground(corFundo);

		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Cadastrar");
		btnCriar.setForeground(fonteLetra);
		btnCriar.setBackground(corFundoBtn);

    	btnCancelar = new JButton("Cancelar");
    	btnCancelar.setForeground(fonteLetra);
    	btnCancelar.setBackground(corFundoBtn);


    	btnCriar.setSize(30, 50);
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(corFundo);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			if(txtNome.getText() == null || txtNome.getText().trim().equals("")) {
				openDialog("error");
				return;
			}
			if (!cadastrarArtista(txtNome.getText())) {
				openDialog("error");
				return;
			}
			this.dispose();
			new ArtistasView();
			openDialog("success");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
