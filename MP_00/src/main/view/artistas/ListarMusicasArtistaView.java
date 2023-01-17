package main.view.artistas;

import static main.model.Artista.artistasCadastrados;

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
import main.model.Artista;
import main.model.Musica;

public class ListarMusicasArtistaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<Artista> cboxArtista;

	private JList<Musica> lista;

	private JButton btnVoltar;

	public ListarMusicasArtistaView() {
		inicializar();
	}

	//	-------------------------------------------------------------

	private void inicializar() {
		setTitle("CRUD Artista");
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

		lblTitle = new JLabel("Lista de músicas do Artista");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblArtista = new JLabel("Artista:");
		
		pnlForm.add(lblArtista, BorderLayout.NORTH);

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);
		
		pnlForm.add(cboxArtista, BorderLayout.NORTH);
		
		Artista selected = (Artista) cboxArtista.getSelectedItem();

		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}
		
		pnlForm.add(lista, BorderLayout.CENTER);

		cboxArtista.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Artista selected = (Artista) cboxArtista.getSelectedItem();
					Musica[] musicas = selected.getMusicas().toArray(new Musica[selected.getMusicas().size()]);
					lista.setListData(musicas);
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
			new ArtistasView();
		}
	}

}
