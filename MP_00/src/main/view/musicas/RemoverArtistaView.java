package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;
import main.model.Musica;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

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
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setFont(AesthethicsView.getFonte());

		lblMusica = new JLabel("Música:");
		lblMusica.setForeground(AesthethicsView.getCorLetra());
		lblMusica.setFont(AesthethicsView.getFonte());

		String[] arrayMusica = new String[musicasCadastradas.size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(arrayMusica);
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundoBtn());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());

		Musica musicaSelecionada = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());

		Artista[] array = new Artista[musicaSelecionada.getArtistas().size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicaSelecionada.getArtistas().get(i);
		}
		cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setBackground(AesthethicsView.getCorFundoBtn());
		cboxArtista.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		pnlForm.setBackground(AesthethicsView.getCorFundo());
		

		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxArtista.removeAllItems();

				Musica musicaSelecionada1 = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
				Artista[] array1 = new Artista[musicaSelecionada1.getArtistas().size()];
				for (int i = 0; i < array1.length; i++) {
					cboxArtista.addItem(musicaSelecionada1.getArtistas().get(i));
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
		btnRemove.setForeground(AesthethicsView.getCorFundo());
		btnRemove.setBackground(AesthethicsView.getCorLetra());
		btnRemove.setFont(AesthethicsView.getFonte());

		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnRemove);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());

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
