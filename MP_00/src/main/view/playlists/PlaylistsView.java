package main.view.playlists;

import main.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Musica.musicasCadastradas;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class PlaylistsView extends JFrame implements ActionListener{
	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnMusicas;
	private JButton btnAddMusica;
	private JButton btnRmvMusica;
	private JButton btnVoltar;

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
    
    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Playlists");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnAdd = new JButton("Cadastrar playlist");
    	btnRemove = new JButton("Remover playlist");
    	btnUpdate = new JButton("Atualizar playlist");
    	btnList = new JButton("Listar Playlists");
    	btnMusicas = new JButton("Listar Músicas da Playlist");
    	btnAddMusica = new JButton("Adicionar música na playlist");
    	btnRmvMusica = new JButton("Remover música da playlist");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnMusicas);
    	pnlBody.add(btnAddMusica);
    	pnlBody.add(btnRmvMusica);
    	
		return pnlBody;
	}
    
    public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	
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
