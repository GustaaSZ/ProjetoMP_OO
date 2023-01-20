package main.view.playlists;

import main.util.AesthethicsView;
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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

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
    	
		// Mudando a cor da letra
		btnAdd.setForeground(AesthethicsView.getCorLetra());
    	btnRemove.setForeground(AesthethicsView.getCorLetra());
    	btnUpdate.setForeground(AesthethicsView.getCorLetra());
    	btnList.setForeground(AesthethicsView.getCorLetra());
    	btnMusicas.setForeground(AesthethicsView.getCorLetra());
    	btnAddMusica.setForeground(AesthethicsView.getCorLetra());
    	btnRmvMusica.setForeground(AesthethicsView.getCorLetra());

		// Mudando a cor de fundo dos botões
		btnAdd.setBackground(AesthethicsView.getCorFundoBtn());
    	btnRemove.setBackground(AesthethicsView.getCorFundoBtn());
    	btnUpdate.setBackground(AesthethicsView.getCorFundoBtn());
    	btnList.setBackground(AesthethicsView.getCorFundoBtn());
    	btnMusicas.setBackground(AesthethicsView.getCorFundoBtn());
    	btnAddMusica.setBackground(AesthethicsView.getCorFundoBtn());
    	btnRmvMusica.setBackground(AesthethicsView.getCorFundoBtn());

		// Mudando a fonte dos botões
		btnAdd.setFont(AesthethicsView.getFonteMenor());
    	btnRemove.setFont(AesthethicsView.getFonteMenor());
    	btnUpdate.setFont(AesthethicsView.getFonteMenor());
    	btnList.setFont(AesthethicsView.getFonteMenor());
    	btnMusicas.setFont(AesthethicsView.getFonteMenor());
    	btnAddMusica.setFont(AesthethicsView.getFonteMenor());
    	btnRmvMusica.setFont(AesthethicsView.getFonteMenor());


    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnMusicas);
    	pnlBody.add(btnAddMusica);
    	pnlBody.add(btnRmvMusica);
		pnlBody.setBackground(AesthethicsView.getCorFundo());
    	
		return pnlBody;
	}
    
    public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	btnVoltar.setForeground(AesthethicsView.getCorFundo());
		btnVoltar.setBackground(AesthethicsView.getCorLetra());
		btnVoltar.setFont(AesthethicsView.getFonte());

    	pnlRodape.add(btnVoltar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
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
