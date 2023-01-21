package main.view.artistas;


import main.view.MainView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Artista.artistasCadastrados;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class ArtistasView extends JFrame implements ActionListener{
	
	private MyJPanel pnlTitle;
	private MyJPanel pnlBody;
	private MyJPanel pnlRodape;

	private MyJLabel lblTitle;

	private MyJButton btnAdd;
	private MyJButton btnRemove;
	private MyJButton btnUpdate;
	private MyJButton btnList;
	private MyJButton btnListMusicas;
	private MyJButton btnBuscar;
	private MyJButton btnVoltar;

	public ArtistasView() {
		inicializar(this, "CRUD Artistas", getPnlTitle(), getPnlBody(), getPnlRodape());

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnListMusicas.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnVoltar.addActionListener(this);
	}

// ---------------------------------------------------------------
    
	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		lblTitle = new MyJLabel("Crud de Artistas");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

 // ---------------------------------------------------------------
    
	public MyJPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
		}
		btnAdd = new MyJButton("Cadastrar Artista");
		btnRemove = new MyJButton("Remover Artista");
		btnUpdate = new MyJButton("Atualizar Artista");
		btnList = new MyJButton("Listar Artistas");
		btnBuscar = new MyJButton("Buscar Artista");
		btnListMusicas = new MyJButton("Listar Músicas do Artista");

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnBuscar);
		pnlBody.add(btnListMusicas);

		return pnlBody;
	}

// ---------------------------------------------------------------
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnVoltar = new MyJButton("Voltar", true);
		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}
	
// ---------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			this.dispose();
			new AddArtistasView();
		}

		if (src == btnRemove) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new RemoveArtistaView();
		}

		if (src == btnUpdate) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new UpdateArtistaView();
		}

		if (src == btnList) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new ListarArtistasView();
		}

		if (src == btnBuscar) {
			if (artistasCadastrados.isEmpty()) {
				openDialog("artista");
				return;
			}
			this.dispose();
			new BuscarArtista();
		}
		
		if (src == btnListMusicas) {
			if (musicasCadastradas.isEmpty() || artistasCadastrados.isEmpty()) {
				openDialog("artista_musica");
				return;
			}
			this.dispose();
			new ListarMusicasArtistaView();
		}

		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
	}


}
