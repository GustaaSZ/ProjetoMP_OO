package main.view.playlists;

import main.controller.PlaylistController;
import main.model.Playlist;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.model.Playlist.playlistsCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class UpdatePlaylistView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblPlaylist;
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblDescricao;
	
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	private JComboBox<String> cboxPlaylist;

	private JButton btnUpdt;
	private JButton btnCancelar;

	public UpdatePlaylistView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Atualizar Playlist");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
		

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(5, 2));
		}
		
		lblPlaylist = new JLabel("Playlist:");
		lblPlaylist.setForeground(AesthethicsView.getCorLetra());
		lblPlaylist.setFont(AesthethicsView.getFonte());

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		
		cboxPlaylist = new JComboBox<>(array);
		cboxPlaylist.setForeground(AesthethicsView.getCorLetra());
		cboxPlaylist.setBackground(AesthethicsView.getCorFundoBtn());
		cboxPlaylist.setFont(AesthethicsView.getFonteMenor());

		lblNome = new JLabel("Nome:");
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setFont(AesthethicsView.getFonte());

    	txtNome = new JTextField(15);
		txtNome.setBackground(AesthethicsView.getCorFundoBtn());
		txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());
		txtNome.setText(playlistsCadastradas.get(0).getNome());
    	
    	lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(AesthethicsView.getCorLetra());
		lblDescricao.setFont(AesthethicsView.getFonte());

    	txtDescricao = new JTextField(15);
		txtDescricao.setBackground(AesthethicsView.getCorFundoBtn());
		txtDescricao.setForeground(AesthethicsView.getCorLetra());
		txtDescricao.setFont(AesthethicsView.getFonteMenor());
		txtDescricao.setText(playlistsCadastradas.get(0).getDescricao());
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblDescricao);
    	pnlForm.add(txtDescricao);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		cboxPlaylist.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
				txtNome.setText(selected.getNome());
				txtDescricao.setText(selected.getDescricao());
				}
			});

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnUpdt = new JButton("Atualizar");
		btnUpdt.setForeground(AesthethicsView.getCorFundo());
		btnUpdt.setBackground(AesthethicsView.getCorLetra());
		btnUpdt.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnUpdt);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnUpdt) {
			PlaylistController controller = new PlaylistController(
					buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()));
			controller.atualizarPlaylist(
					txtNome.getText(), 
					txtDescricao.getText()
			);
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
