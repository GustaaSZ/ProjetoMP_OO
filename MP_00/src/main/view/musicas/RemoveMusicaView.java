package main.view.musicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.MusicaController.removerMusica;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;
import main.util.AesthethicsView;
import static main.view.dialog.Dialog.openDialog;

public class RemoveMusicaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<String> cboxMusica;

	private JButton btnRemover;
	private JButton btnCancelar;

	public RemoveMusicaView() {
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Musica");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblArtista = new JLabel("Musica:");
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setBackground(AesthethicsView.getCorFundoBtn());
		lblArtista.setFont(AesthethicsView.getFonte());


		String[] array = new String[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(array);
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundoBtn());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(lblArtista);
		pnlForm.add(cboxMusica);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnRemover.setForeground(AesthethicsView.getCorFundo());
		btnRemover.setBackground(AesthethicsView.getCorLetra());
		btnRemover.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			if (!removerMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
				openDialog("error");
				return;
			}
			this.dispose();
			new MusicasView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}

}
