package main.view.playlists;

import main.view.MainView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Musica.musicasCadastradas;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class PlaylistsView extends JFrame implements ActionListener{
	private MyJPanel pnlTitle;
	private MyJPanel pnlBody;
	private MyJPanel pnlRodape;

	private MyJButton btnAdd;
	private MyJButton btnRemove;
	private MyJButton btnUpdate;
	private MyJButton btnList;
	private MyJButton btnMusicas;
	private MyJButton btnAddMusica;
	private MyJButton btnRmvMusica;
	private MyJButton btnVoltar;

	public PlaylistsView() {
        inicializar(this, "CRUD Playlist", getPnlTitle(), getPnlBody(), getPnlRodape());

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnMusicas.addActionListener(this);
		btnAddMusica.addActionListener(this);
		btnRmvMusica.addActionListener(this);
		btnVoltar.addActionListener(this);
    }
    
    public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
		MyJLabel lblTitle = new MyJLabel("Crud de Playlists");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
    
    public MyJPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
    	}
    	btnAdd = new MyJButton("Cadastrar playlist");
    	btnRemove = new MyJButton("Remover playlist");
    	btnUpdate = new MyJButton("Atualizar playlist");
    	btnList = new MyJButton("Listar Playlists");
    	btnMusicas = new MyJButton("Listar Músicas da Playlist");
    	btnAddMusica = new MyJButton("Adicionar música na playlist");
    	btnRmvMusica = new MyJButton("Remover música da playlist");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnMusicas);
    	pnlBody.add(btnAddMusica);
    	pnlBody.add(btnRmvMusica);

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
				new AddPlaylistView();
		}
		
		if (src == btnRemove) {
			if (playlistsCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new RemovePlaylistView();
		}
		
		if (src == btnUpdate) {
			if (playlistsCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new UpdatePlaylistView();
		}
		
		if (src == btnList) {
			if (playlistsCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new ListarPlaylistsView();
		}

		if (src == btnMusicas) {
			if (playlistsCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new MusicasView();
		}
		
		if (src == btnAddMusica) {
			if (playlistsCadastradas.isEmpty() || musicasCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new AddMusicaView();
		}

		if (src == btnRmvMusica) {
			if (playlistsCadastradas.isEmpty() || musicasCadastradas.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new RemoveMusicaView();
		}
		
		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
	}
}
