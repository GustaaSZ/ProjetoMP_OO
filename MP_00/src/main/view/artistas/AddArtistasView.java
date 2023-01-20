package main.view.artistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.util.AesthethicsView;
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

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	// ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	// JLabel label = new JLabel(imag);

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

		//    	Mudando a cor da letra e a fonte
    	lblTitle.setForeground(AesthethicsView.getCorLetra());
    	lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);

		//		Mudando a cor do btn
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	lblNome = new JLabel("Nome:");

		// Mudando a cor da letra, o fundo e a fonte da lblNome
		lblNome.setForeground(AesthethicsView.getCorLetra());
    	lblNome.setBackground(AesthethicsView.getCorFundo());
		lblNome.setFont(AesthethicsView.getFonte());

		// Definindo a cor de fundo o Jtxt, o tamanho e a cor do texto digitado
    	txtNome = new JTextField(20);
    	txtNome.setBackground(AesthethicsView.getCorFundoBtn());
    	txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());


    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		
		// Adicionando a imagem
    	// pnlForm.add(label);

		// preenchendo as partes do body que não foram preenchidas com a cor de fundo
    	pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Cadastrar");
		btnCriar.setForeground(AesthethicsView.getCorFundo());
		btnCriar.setBackground(AesthethicsView.getCorLetra());
		btnCriar.setFont(AesthethicsView.getFonteMenor());

    	btnCancelar = new JButton("Cancelar");
    	btnCancelar.setForeground(AesthethicsView.getCorFundo());
    	btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonteMenor());

    	btnCriar.setSize(30, 50);
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
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
