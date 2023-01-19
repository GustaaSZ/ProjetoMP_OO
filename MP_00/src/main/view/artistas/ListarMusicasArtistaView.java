package main.view.artistas;

import main.model.Artista;
import main.model.Musica;

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

	//	CORES
	Font fonte = new Font("Courier New", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);

	// ----- Cinza escuro -------
	Color corFundoBtn = new Color(54, 54, 54);

	// ------- Verde forte ---------
	Color fonteLetra = new Color(50, 205, 50);

	// ---- Preto escuro ------
	Color corFundo = new Color(28 ,28 ,28);

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
	JLabel label = new JLabel(imag);

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
		lblTitle.setForeground(fonteLetra);

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(corFundo);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblArtista = new JLabel("Artista:");
		lblArtista.setForeground(fonteLetra);


		pnlForm.add(lblArtista, BorderLayout.NORTH);

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(fonteLetra);
		cboxArtista.setBackground(corFundo);


		pnlForm.add(cboxArtista, BorderLayout.NORTH);
		
		Artista selected = (Artista) cboxArtista.getSelectedItem();

		DefaultListModel<Musica> model = new DefaultListModel<Musica>();
		lista = new JList<Musica>(model);
		lista.setBackground(corFundo);
    	lista.setForeground(fonteLetra);

		for (int i = 0; i < selected.getMusicas().size(); i++) {
			model.add(i, selected.getMusicas().get(i));
		}
		
		pnlForm.add(lista, BorderLayout.CENTER);
		pnlForm.add(label);
    	pnlForm.setBackground(corFundo);

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
		btnVoltar.setForeground(corFundo);
		btnVoltar.setBackground(fonteLetra);

		pnlRodape.add(btnVoltar);
		pnlRodape.setBackground(corFundo);
		
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
