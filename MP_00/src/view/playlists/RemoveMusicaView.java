package view.playlists;

import static controller.PlaylistController.buscarPlaylistPorNome;
import static controller.MusicaController.buscarMusicaPorNome;
import static model.Playlist.playlistsCadastradas;
import static view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.PlaylistController;
import model.Musica;
import model.Playlist;

public class RemoveMusicaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblMusica;
	
	private JComboBox<String> cboxPlaylist;
	private JComboBox<String> cboxMusica;

	private JButton btnRmv;
	private JButton btnCancelar;

	public RemoveMusicaView() {
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Playlist");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnRmv.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Música de alguma Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}
		
		lblPlaylist = new JLabel("Playlist:");

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		
		cboxPlaylist = new JComboBox<>(array);

		Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());

		lblMusica = new JLabel("Música:");
    	
		String[] arrayMusica = new String[selected.getMusicas().size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = selected.getMusicas().get(i).getNome();
		}
		
		cboxMusica = new JComboBox<>(arrayMusica);
    	
		pnlForm.add(lblPlaylist);
    	pnlForm.add(cboxPlaylist);
    	pnlForm.add(lblMusica);
    	pnlForm.add(cboxMusica);

		cboxPlaylist.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cboxMusica.removeAllItems();
					
					Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
					Musica[] array = new Musica[selected.getMusicas().size()];
					for (int i = 0; i < array.length; i++) {
						cboxMusica.addItem(selected.getMusicas().get(i).getNome());
					}
				}
			}
		});

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRmv = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnRmv);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRmv) {

			PlaylistController controller = new PlaylistController(
				buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())
				);
			
			if (!controller.removerMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
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
