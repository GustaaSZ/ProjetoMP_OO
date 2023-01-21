package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.*;
import static main.model.Musica.musicasCadastradas;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoverArtistaView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJComboBox<Artista> cboxArtista;
	private MyJComboBox<String> cboxMusica;

	private MyJButton btnRemove;
	private MyJButton btnCancelar;

	public RemoverArtistaView() {
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemove.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		MyJLabel lblTitle = new MyJLabel("Remover Artista de alguma Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(2, 2), true);
		}

		MyJLabel lblArtista = new MyJLabel("Artista:");
		MyJLabel lblMusica = new MyJLabel("Música:");

		cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());
		cboxArtista = new MyJComboBox<>(
				arrayArtistasNaMusica(musicasCadastradas.get(0)));

		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		
		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxArtista.removeAllItems();

				var array = arrayArtistasNaMusica(
						buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));

				for (Artista artista : array) {
					cboxArtista.addItem(artista);
				}
			}
		});

		return pnlForm;
	}

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnRemove = new MyJButton("Remover", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnRemove);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemove) {
			MusicaController controller = new MusicaController(
					buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
			if (!controller.removerArtista((Artista) cboxArtista.getSelectedItem())) {
				openDialog("musica_sem_artista");
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
