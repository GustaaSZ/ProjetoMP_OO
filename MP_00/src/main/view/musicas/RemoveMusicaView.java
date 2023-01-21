package main.view.musicas;

import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoveMusicaView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJComboBox<String> cboxMusica;

	private MyJButton btnRemover;
	private MyJButton btnCancelar;

	public RemoveMusicaView() {
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}

		MyJLabel lblTitle = new MyJLabel("Remover Musica");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(1, 2), true);
		}
		MyJLabel lblArtista = new MyJLabel("Musica:");
		cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

		pnlForm.add(lblArtista);
		pnlForm.add(cboxMusica);

		return pnlForm;
	}

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnRemover = new MyJButton("Remover", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

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
