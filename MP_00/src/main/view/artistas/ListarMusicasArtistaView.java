package main.view.artistas;

import main.model.Artista;
import main.model.Musica;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.model.Artista.artistasCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarMusicasArtistaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<Artista> cboxArtista;

	private JList<Musica> lista;

	private JButton btnVoltar;

	// // Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// // a imagem que coloquei no mesmo pacote da main View

	// ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	// JLabel label = new JLabel(imag);

	public ListarMusicasArtistaView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnVoltar.addActionListener(this);
	}


	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Lista de músicas do Artista");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblArtista = new JLabel("Artista:");
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setFont(AesthethicsView.getFonte());


		pnlForm.add(lblArtista, BorderLayout.NORTH);

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setBackground(AesthethicsView.getCorFundo());
		cboxArtista.setFont(AesthethicsView.getFonteMenor());


		pnlForm.add(cboxArtista, BorderLayout.NORTH);
		
		Artista selected = (Artista) cboxArtista.getSelectedItem();

		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);
		lista.setBackground(AesthethicsView.getCorFundo());
    	lista.setForeground(AesthethicsView.getCorLetra());
		lista.setFont(AesthethicsView.getFonteMenor());

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}
		
		pnlForm.add(lista, BorderLayout.CENTER);
		// pnlForm.add(label);
    	pnlForm.setBackground(AesthethicsView.getCorFundo());

		cboxArtista.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Artista selected1 = (Artista) cboxArtista.getSelectedItem();
				Musica[] musicas = selected1.getMusicas().toArray(new Musica[selected1.getMusicas().size()]);
				lista.setListData(musicas);
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
		btnVoltar.setForeground(AesthethicsView.getCorFundo());
		btnVoltar.setBackground(AesthethicsView.getCorLetra());
		btnVoltar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnVoltar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
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
