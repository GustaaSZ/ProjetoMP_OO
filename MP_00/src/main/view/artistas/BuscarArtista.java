package main.view.artistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.util.AesthethicsView;
import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.objetoEncontrado;
import static main.view.dialog.Dialog.openDialog;

public class BuscarArtista extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	
	private JTextField txtNome;
	
	
	private JButton btnBuscar;
	private JButton btnCancelar;

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	// ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	// JLabel label = new JLabel(imag);

	public BuscarArtista(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnBuscar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}


	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Buscar Artista");
    	// Mudando a cor da letra e a fonte
    	lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
    	
    	pnlTitle.add(lblTitle);

		// Mudando a cor do btn
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	lblNome = new JLabel("Nome:");
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setFont(AesthethicsView.getFonte());

    	txtNome = new JTextField(20);
		txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setBackground(AesthethicsView.getCorFundo());
		txtNome.setFont(AesthethicsView.getFonteMenor());
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		// pnlForm.add(label);

		pnlForm.setBackground(AesthethicsView.getCorFundo());
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(AesthethicsView.getCorFundo());
		btnBuscar.setBackground(AesthethicsView.getCorLetra());
		btnBuscar.setFont(AesthethicsView.getFonte());

    	
		btnCancelar = new JButton("Voltar");
    	btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

    	btnBuscar.setSize(30, 50);
    	
    	pnlRodape.add(btnBuscar);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnBuscar) {
			if(txtNome.getText() == null || txtNome.getText().trim().equals("")) {
				openDialog("error");
				return;
			}

			if (objetoEncontrado(buscarArtistaPorNome(txtNome.getText()))) {
				return;
			}
			openDialog("artista_nao_encontrado");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
