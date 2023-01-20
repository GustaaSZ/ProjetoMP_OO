package main.view.musicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.util.Inicializacao.inicializar;

public class LetraView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblMusica;
	private JScrollPane scrollPane;
	private JTextArea txtLetra;
	private JComboBox<String> cboxMusica;

	private JButton btnVoltar;

	public LetraView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}

	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Letra da Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblMusica = new JLabel("Musica:");
		
		pnlForm.add(lblMusica, BorderLayout.NORTH);

		cboxMusica = new JComboBox<>(arrayMusicasCadastradas());

		pnlForm.add(cboxMusica, BorderLayout.NORTH);

		txtLetra = new JTextArea();
		txtLetra.setLineWrap(true);
		txtLetra.setEditable(false);
		txtLetra.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem())
				.getLetra());

		scrollPane = new JScrollPane(txtLetra);

		pnlForm.add(scrollPane);

		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				txtLetra.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem())
						.getLetra());
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
			new MusicasView();
		}
	}
}
