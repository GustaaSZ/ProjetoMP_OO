package main.view.playlists;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.cadastrarPlaylist;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AddPlaylistView extends JFrame implements ActionListener{
	
	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;
	
	private MyJLabel lblTitle;
	private MyJLabel lblNome;
	private MyJLabel lblDescricao;
	private MyJTextField txtNome;
	private MyJTextField txtDescricao;
	
	private MyJButton btnCriar;
	private MyJButton btnCancelar;

	public AddPlaylistView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	lblTitle = new MyJLabel("Cadastro de Playlist");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	public MyJPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new MyJPanel(new GridLayout(2,2), true);
    	}
    	lblNome = new MyJLabel("Nome:");
    	txtNome = new MyJTextField(15);

    	lblDescricao = new MyJLabel("Descrição:");
    	txtDescricao = new MyJTextField(15);

    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblDescricao);
    	pnlForm.add(txtDescricao);

		return pnlForm;
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
				 if (!cadastrarPlaylist(
					txtNome.getText(),
					txtDescricao.getText())) {
				openDialog("error");
				return;
			}
			this.dispose();
			new PlaylistsView();
			openDialog("success");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new PlaylistsView();
		}
	}
}
