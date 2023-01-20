package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class AdicionarArtistasView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;
	private JLabel lblMusica;

	private JComboBox<Artista> cboxArtista;
	private JComboBox<String> cboxMusica;

	private JButton btnAdd;
	private JButton btnCancelar;

	public AdicionarArtistasView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Adicionar Artista");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}

		lblArtista = new JLabel("Artista:");
		lblArtista.setForeground(AesthethicsView.getCorFundo());
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setFont(AesthethicsView.getFonte());

		lblMusica = new JLabel("Música:");
		lblMusica.setForeground(AesthethicsView.getCorFundo());
		lblMusica.setForeground(AesthethicsView.getCorLetra());
		lblMusica.setFont(AesthethicsView.getFonte());

		cboxArtista = new JComboBox<>(arrayArtistasCadastrados());
		cboxArtista.setBackground(AesthethicsView.getCorFundo());
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setFont(AesthethicsView.getFonteMenor());

		cboxMusica = new JComboBox<>(arrayMusicasCadastradas());
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundo());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.setBackground(AesthethicsView.getCorFundo());
		
		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Cadastrar");
		btnAdd.setForeground(AesthethicsView.getCorFundo());
		btnAdd.setBackground(AesthethicsView.getCorLetra());
		btnAdd.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
    	btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());


		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			MusicaController controller = new MusicaController(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
			if (!controller.adicionarArtista((Artista) cboxArtista.getSelectedItem())) {
				openDialog("artista_repetido");
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
