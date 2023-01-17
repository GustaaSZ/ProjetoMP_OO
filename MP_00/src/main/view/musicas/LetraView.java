package main.view.musicas;

import main.model.Musica;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;

public class LetraView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblMusica;
	private JLabel lblLetra;

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

		String[] array = new String[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(array);

		pnlForm.add(cboxMusica, BorderLayout.NORTH);

		Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
		
		lblLetra = new JLabel(selected.getLetra());
		pnlForm.add(lblLetra, BorderLayout.CENTER);
		lblLetra.setBorder(border);
		
		cboxMusica.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
					lblLetra.setText(selected.getLetra());
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
			new MusicasView();
		}
	}

	Border border = new Border() {
		@Override
		public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
			g.drawRect(x, y, width - 1, height - 1);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public Insets getBorderInsets(Component arg0) {
			return new Insets(1, 1, 1, 1);
		}
	};
}
