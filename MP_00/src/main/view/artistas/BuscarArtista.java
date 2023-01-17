package main.view.artistas;

import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	lblNome = new JLabel("Nome:");
    	txtNome = new JTextField(20);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnBuscar = new JButton("Buscar");
    	btnCancelar = new JButton("Voltar");
    	
    	btnBuscar.setSize(30, 50);
    	
    	pnlRodape.add(btnBuscar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnBuscar) {
			if(txtNome.getText() == null || txtNome.getText().trim() == "") {
				openDialog("error");
			}
			
			Artista artista = buscarArtistaPorNome(txtNome.getText());

			try {
				if (!artista.equals(null)) {
					objetoEncontrado(artista);
					return;
				}
			} catch (NullPointerException ex) {
				openDialog("artista_nao_encontrado");
			}
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
