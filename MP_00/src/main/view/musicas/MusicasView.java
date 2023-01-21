package main.view.musicas;

import main.view.MainView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class MusicasView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlBody;
	private MyJPanel pnlRodape;

	private MyJButton btnAdd;
	private MyJButton btnRemove;
	private MyJButton btnUpdate;
	private MyJButton btnList;
	private MyJButton btnVoltar;
	private MyJButton btnAddArt;
	private MyJButton btnRmvArt;
	private MyJButton btnLetra;
	
	public MusicasView() {
		
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlBody(), getPnlRodape());
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnAddArt.addActionListener(this);
		btnRmvArt.addActionListener(this);
		btnLetra.addActionListener(this);

	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		MyJLabel lblTitle = new MyJLabel("Crud de musicas");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
		}
		btnAdd = new MyJButton("Cadastrar Musica");
		btnRemove = new MyJButton("Remover Musica");
		btnUpdate = new MyJButton("Atualizar Musica");
		btnList = new MyJButton("Listar Musicas");
		btnAddArt = new MyJButton("Adicionar artista na Música");
		btnRmvArt = new MyJButton("Remover artista da Música");
		btnLetra = new MyJButton("Ver letra da Música");

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnLetra);
		pnlBody.add(btnAddArt);
		pnlBody.add(btnRmvArt);

		return pnlBody;
	}

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnVoltar = new MyJButton("Voltar", true);
		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			this.dispose();
			new AddMusicaView();
		}

		if (src == btnRemove) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new RemoveMusicaView();
		}

		if (src == btnUpdate) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new UpdateMusicaView();
		}

		if (src == btnList) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new ListarMusicasView();
		}
		
		if (src == btnAddArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new AdicionarArtistasView();
		}

		if (src == btnRmvArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new RemoverArtistaView();
		}

		if (src == btnLetra) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			this.dispose();
			new LetraView();
		}

		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
	}
}
