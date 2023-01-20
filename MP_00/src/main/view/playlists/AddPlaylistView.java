package main.view.playlists;

import javax.swing.*;

import main.util.AesthethicsView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.cadastrarPlaylist;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class AddPlaylistView extends JFrame implements ActionListener{
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddPlaylistView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Cadastro de Playlist");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(2,2));
    	}
    	
    	lblNome = new JLabel("Nome:");
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setFont(AesthethicsView.getFonte());

    	txtNome = new JTextField(15);
    	txtNome.setBackground(AesthethicsView.getCorFundoBtn());
		txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());

    	lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(AesthethicsView.getCorLetra());
		lblDescricao.setFont(AesthethicsView.getFonte());

    	txtDescricao = new JTextField(15);
		txtDescricao.setBackground(AesthethicsView.getCorFundoBtn());
		txtDescricao.setForeground(AesthethicsView.getCorLetra());
		txtDescricao.setFont(AesthethicsView.getFonteMenor());

    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblDescricao);
    	pnlForm.add(txtDescricao);
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
		btnCriar.setFont(AesthethicsView.getFonte());

    	btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
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
