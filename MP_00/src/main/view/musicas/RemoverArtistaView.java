package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class RemoverArtistaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;
	private JLabel lblMusica;

	private JComboBox<Artista> cboxArtista;
	private JComboBox<String> cboxMusica;

	private JButton btnRemove;
	private JButton btnCancelar;

	public RemoverArtistaView() {
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemove.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Artista de alguma Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}

		lblArtista = new JLabel("Artista:");
		lblMusica = new JLabel("Música:");

		cboxMusica = new JComboBox<>(arrayMusicasCadastradas());

		cboxArtista = new JComboBox<>(
				arrayArtistasNaMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem())));

		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		
		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxArtista.removeAllItems();

				var array = arrayArtistasNaMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
				for (int i = 0; i < array.length; i++) {
					cboxArtista.addItem(buscarMusicaPorNome((String) cboxMusica.getSelectedItem())
							.getArtistas().get(i));
				}
			}
		});

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemove = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");

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
