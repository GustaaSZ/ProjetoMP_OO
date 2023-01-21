package main.view.artistas;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.objetoEncontrado;
import static main.view.components.Dialog.openDialog;

public class BuscarArtista extends JFrame implements ActionListener{

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;
	
	private MyJLabel lblTitle;
	private MyJLabel lblNome;
	
	private MyJTextField txtNome;
	
	
	private MyJButton btnBuscar;
	private MyJButton btnCancelar;

	public BuscarArtista(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnBuscar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}


	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	lblTitle = new MyJLabel("Buscar Artista");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	public MyJPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
    	}
    	lblNome = new MyJLabel("Nome:");
    	txtNome = new MyJTextField(20);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);

		return pnlForm;
	}
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnBuscar = new MyJButton("Buscar");
		btnCancelar = new MyJButton("Voltar");

    	pnlRodape.add(btnBuscar, true);
    	pnlRodape.add(btnCancelar, true);
		
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
