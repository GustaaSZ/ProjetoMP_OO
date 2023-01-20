package main.view.ouvintes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.cadastrarOuvinte;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class AddOuvintesView extends JFrame implements ActionListener{

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	// Instânciando componentes da classe JLabel (textos)
	private JLabel lblTitle;
	private JLabel lblNome;
	
	// Instânciando componentes da classe JTextField (Campo de texto)
	private JTextField txtNome;
	
	// Instânciando componentes da classe JButton, que por sua vez são botões
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddOuvintesView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
//	-----------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
		
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	-----------------------------------------------------------------------------
	public JPanel getPnlForm() {
		
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	// Definindo a mensagem que irá aparecer no JLabel lblNome
    	lblNome = new JLabel("Nome:");
    	// Definindo o tamanho do campo de texto
    	txtNome = new JTextField(20);
    	
    	// Add os componentes ao JPanel pnlForm
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		return pnlForm;
	}
	
//	-----------------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		// Definindo a mensagem que irá aparecer no btnCriar
		btnCriar = new JButton("Cadastrar");
		// Definindo a mensagem que irá aparecer no btnCancelar
    	btnCancelar = new JButton("Cancelar");
    	
    	// Altura e largura do botão de criar
    	btnCriar.setSize(30, 50);
    	
    	// Add os componentes ao JPanel pnlRodape
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

