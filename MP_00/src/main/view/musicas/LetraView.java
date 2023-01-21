package main.view.musicas;

import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;

public class LetraView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJTextArea txtLetra;
	private MyJComboBox<String> cboxMusica;

	private MyJButton btnVoltar;

	public LetraView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}

		MyJLabel lblTitle = new MyJLabel("Letra da Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new BorderLayout(), true);
		}
		cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

		txtLetra = new MyJTextArea();
		txtLetra.setText(musicasCadastradas.get(0).getLetra());

		JScrollPane scrollPane = new JScrollPane(txtLetra);

		pnlForm.add(cboxMusica, BorderLayout.NORTH);
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

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnVoltar = new MyJButton("Voltar", true);
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
