package main.view.artistas;

import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		btnCriar = new JButton("Cadastrar");
    	btnCancelar = new JButton("Cancelar");
    	
    	btnCriar.setSize(30, 50);
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			if(txtNome.getText() == null || txtNome.getText().trim() == "") {
				openDialog("error");
			}
			new Artista(txtNome.getText().trim());
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
