package main.view.ouvintes;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.objetoEncontrado;
import static main.view.components.Dialog.openDialog;

public class BuscarOuvinte extends JFrame implements ActionListener{

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJTextField txtNome;

	private MyJButton btnBuscar;
	private MyJButton btnCancelar;

	public BuscarOuvinte(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnBuscar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
		MyJLabel lblTitle = new MyJLabel("Buscar Artista");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	public MyJPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
    	}
		MyJLabel lblNome = new MyJLabel("Nome:");
    	txtNome = new MyJTextField(20);

    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);

		return pnlForm;
	}
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnBuscar = new MyJButton("Buscar", true);
    	btnCancelar = new MyJButton("Voltar", true);

    	pnlRodape.add(btnBuscar);
    	pnlRodape.add(btnCancelar);

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
			if (objetoEncontrado(buscarOuvintePorNome(txtNome.getText()))) {
				return;
			}
			openDialog("ouvinte_nao_encontrado");
		}
		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
}
