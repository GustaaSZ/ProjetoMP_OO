package view.playlists;

import static model.Playlist.playlistsCadastradas;
import static controller.PlaylistController.buscarPlaylistPorNome;
import static view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import model.Musica;
import model.Playlist;

public class MusicasView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblPlaylist;

	private JList<Musica> lista;

	private JComboBox<String> cboxPlaylist;

	private JButton btnVoltar;

	public MusicasView() {
		inicializar();
	}

	//	-------------------------------------------------------------

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

		btnVoltar.addActionListener(this);
	}

	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Músicas da Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblPlaylist = new JLabel("Playlist:");
		
		pnlForm.add(lblPlaylist, BorderLayout.NORTH);

		String[] array = new String[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i).getNome();
		}
		cboxPlaylist = new JComboBox<>(array);

		pnlForm.add(cboxPlaylist, BorderLayout.NORTH);

		Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
		
		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}

		pnlForm.add(lista, BorderLayout.CENTER);

		cboxPlaylist.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Playlist selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
					Musica[] musicas = selected.getMusicas().toArray(new Musica[selected.getMusicas().size()]);
					if (musicas.length > 0) {
						lista.setListData(musicas);
					} else {
						lista.setListData(musicas);
						openDialog("playlist_vazia");
					}
				}
			}
		});
		return pnlForm;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnVoltar = new JButton("Voltar");

		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnVoltar) {
			this.dispose();
			new PlaylistsView();
		}
	}
}
