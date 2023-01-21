package main.view.ouvintes;

import main.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import main.util.AesthethicsView;
import static main.view.dialog.Dialog.openDialog;

public class OuvintesView extends JFrame implements ActionListener{
	
	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnBuscar;
	private JButton btnAddPlaylist;
	private JButton btnRmvPlaylist;
	private JButton btnListPlaylists;
	private JButton btnVoltar;

	public OuvintesView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlBody(), getPnlRodape());

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnListPlaylists.addActionListener(this);
		btnList.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnAddPlaylist.addActionListener(this);
		btnRmvPlaylist.addActionListener(this);
		btnVoltar.addActionListener(this);
    }

    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Ouvintes");
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
    	
    	btnAdd = new JButton("Adicionar Ouvinte");
    	btnRemove = new JButton("Remover Ouvinte");
    	btnUpdate = new JButton("Atualizar Ouvinte");
    	btnList = new JButton("Listar Ouvintes");
    	btnBuscar = new JButton("Buscar Ouvinte");
		btnAddPlaylist = new JButton("Adicionar Playlist");
		btnRmvPlaylist = new JButton("Remover Playlist");
    	btnListPlaylists = new JButton("Listar Playlists do Ouvinte");
    	
		// Cor das letras
		btnAdd.setForeground(AesthethicsView.getCorLetra());
    	btnRemove.setForeground(AesthethicsView.getCorLetra());
    	btnUpdate.setForeground(AesthethicsView.getCorLetra());
    	btnList.setForeground(AesthethicsView.getCorLetra());
    	btnBuscar.setForeground(AesthethicsView.getCorLetra());
		btnAddPlaylist.setForeground(AesthethicsView.getCorLetra());
		btnRmvPlaylist.setForeground(AesthethicsView.getCorLetra());
    	btnListPlaylists.setForeground(AesthethicsView.getCorLetra());


		// Cor de fundo dos botões
		btnAdd.setBackground(AesthethicsView.getCorFundoBtn());
    	btnRemove.setBackground(AesthethicsView.getCorFundoBtn());
    	btnUpdate.setBackground(AesthethicsView.getCorFundoBtn());
    	btnList.setBackground(AesthethicsView.getCorFundoBtn());
    	btnBuscar.setBackground(AesthethicsView.getCorFundoBtn());
		btnAddPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
		btnRmvPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
    	btnListPlaylists.setBackground(AesthethicsView.getCorFundoBtn());

		// Fonte dos botões
		btnAdd.setFont(AesthethicsView.getFonteMenor());
    	btnRemove.setFont(AesthethicsView.getFonteMenor());
    	btnUpdate.setFont(AesthethicsView.getFonteMenor());
    	btnList.setFont(AesthethicsView.getFonteMenor());
    	btnBuscar.setFont(AesthethicsView.getFonteMenor());
		btnAddPlaylist.setFont(AesthethicsView.getFonteMenor());
		btnRmvPlaylist.setFont(AesthethicsView.getFonteMenor());
    	btnListPlaylists.setFont(AesthethicsView.getFonteMenor());

    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnBuscar);
    	pnlBody.add(btnAddPlaylist);
    	pnlBody.add(btnRmvPlaylist);
    	pnlBody.add(btnListPlaylists);
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
				new AddOuvintesView();
		}
		
		if (src == btnRemove) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new RemoveOuvinteView();
		}
		
		if (src == btnUpdate) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new UpdateOuvinteView();
		}
		
		if (src == btnList) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new ListarOuvintesView();
		}

		if(src == btnListPlaylists) {
			if(playlistsCadastradas.isEmpty() || ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new ListarPlaylistsOuvinteView();
		}

		if(src == btnAddPlaylist) {
			if(playlistsCadastradas.isEmpty() || ouvintesCadastrados.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new AdicionarPlaylistsView();
		}

		if(src == btnRmvPlaylist) {
			if(playlistsCadastradas.isEmpty() || ouvintesCadastrados.isEmpty()) {
				openDialog("playlist");
				return;
			}
			this.dispose();
			new RemoverPlaylistsView();
		}

		if(src == btnBuscar) {
			if(playlistsCadastradas.isEmpty() || ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			this.dispose();
			new BuscarOuvinte();
		}
		
		if (src == btnVoltar) {
			this.dispose();
			new MainView();
		}
		
	}
}
