package main.view.ouvintes;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.cadastrarOuvinte;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AddOuvintesView extends JFrame implements ActionListener{

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJTextField txtNome;
	
	private MyJButton btnCriar;
	private MyJButton btnCancelar;

	public AddOuvintesView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
		MyJLabel lblTitle = new MyJLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	-----------------------------------------------------------------------------
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
	
//	-----------------------------------------------------------------------------
	
	public MyJPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnCriar = new MyJButton("Cadastrar");
    	btnCancelar = new MyJButton("Cancelar");

    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}
	
//	-----------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			if(txtNome.getText() == null || txtNome.getText().trim().equals("")) {
				openDialog("error");
				return;
			}
			cadastrarOuvinte(txtNome.getText());
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Ouvinte Cadastrado com Sucesso!");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
//	-----------------------------------------------------------------------------
	
}

