package main.view.ouvintes;

import main.view.MainView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class OuvintesView extends JFrame implements ActionListener{
	
	private MyJPanel pnlTitle;
	private MyJPanel pnlBody;
	private MyJPanel pnlRodape;

	private MyJLabel lblTitle;

	private MyJButton btnAdd;
	private MyJButton btnRemove;
	private MyJButton btnUpdate;
	private MyJButton btnList;
	private MyJButton btnBuscar;
	private MyJButton btnAddPlaylist;
	private MyJButton btnRmvPlaylist;
	private MyJButton btnListPlaylists;
	private MyJButton btnVoltar;

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

    public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	lblTitle = new MyJLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
    
    public MyJPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
    	}
    	btnAdd = new MyJButton("Adicionar Ouvinte");
    	btnRemove = new MyJButton("Remover Ouvinte");
    	btnUpdate = new MyJButton("Atualizar Ouvinte");
    	btnList = new MyJButton("Listar Ouvintes");
    	btnBuscar = new MyJButton("Buscar Ouvinte");
		btnAddPlaylist = new MyJButton("Adicionar Playlist");
		btnRmvPlaylist = new MyJButton("Remover Playlist");
    	btnListPlaylists = new MyJButton("Listar Playlists do Ouvinte");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnBuscar);
    	pnlBody.add(btnAddPlaylist);
    	pnlBody.add(btnRmvPlaylist);
    	pnlBody.add(btnListPlaylists);

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
