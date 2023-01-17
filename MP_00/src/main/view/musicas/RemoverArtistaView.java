package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;
import main.model.Musica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
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

		String[] arrayMusica = new String[musicasCadastradas.size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(arrayMusica);

		Musica musicaSelecionada = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());

		Artista[] array = new Artista[musicaSelecionada.getArtistas().size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicaSelecionada.getArtistas().get(i);
		}
		cboxArtista = new JComboBox<>(array);

		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		

		cboxMusica.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cboxArtista.removeAllItems();
					
					Musica musicaSelecionada = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
					Artista[] array = new Artista[musicaSelecionada.getArtistas().size()];
					for (int i = 0; i < array.length; i++) {
						cboxArtista.addItem(musicaSelecionada.getArtistas().get(i));
					}
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
			
			Musica musicaSelecionada = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
			MusicaController controller = new MusicaController(musicaSelecionada);
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
