package main.view.musicas;

import main.model.Musica;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
// import java.util.concurrent.LinkedBlockingDeque;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
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

		lblMusica = new JLabel("Musica:");
		lblMusica.setBackground(AesthethicsView.getCorFundo());
		lblMusica.setForeground(AesthethicsView.getCorLetra());
		lblMusica.setFont(AesthethicsView.getFonte());
		
		pnlForm.add(lblMusica, BorderLayout.NORTH);

		String[] array = new String[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(array);
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundo());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());


		pnlForm.add(cboxMusica, BorderLayout.NORTH);

		Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());

		txtLetra = new JTextArea();
		txtLetra.setLineWrap(true);
		txtLetra.setText(selected.getLetra());
		txtLetra.setEditable(false);

		txtLetra.setForeground(AesthethicsView.getCorLetra());
		txtLetra.setBackground(AesthethicsView.getCorFundo());
		txtLetra.setFont(AesthethicsView.getFonteMenor());

		scrollPane = new JScrollPane(txtLetra);
		scrollPane.setBackground(AesthethicsView.getCorFundo());

		pnlForm.add(scrollPane);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Musica selected1 = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
				txtLetra.setText(selected1.getLetra());
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
			new MusicasView();
		}
	}
}
