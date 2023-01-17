package main.view.ouvintes;

import main.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
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
		btnVoltar.addActionListener(this);
    }

    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
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
    	btnListPlaylists = new JButton("Listar Playlists do Ouvinte");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnBuscar);
    	pnlBody.add(btnAddPlaylist);
    	pnlBody.add(btnListPlaylists);

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
