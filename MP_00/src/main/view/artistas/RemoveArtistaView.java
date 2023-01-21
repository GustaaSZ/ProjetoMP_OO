package main.view.artistas;

import main.model.Artista;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.ArtistaController.removerArtistaCadastrado;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoveArtistaView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJLabel lblTitle;
	private MyJLabel lblArtista;

	private MyJComboBox<Artista> cboxArtista;

	private MyJButton btnRemover;
	private MyJButton btnCancelar;

	public RemoveArtistaView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	//	-------------------------------------------------------------

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		lblTitle = new MyJLabel("Remover Artista");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
		}

		lblArtista = new MyJLabel("Artista que deseja remover:");
		cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);

		return pnlForm;
	}

	//	-------------------------------------------------------------

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

	//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			
			if(!removerArtistaCadastrado((Artista) cboxArtista.getSelectedItem())) {
				openDialog("error");
				return;
			}
			this.dispose();
			new ArtistasView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}

}
