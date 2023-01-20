package main.view.artistas;

import main.model.Artista;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.ArtistaController.removerArtistaCadastrado;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class RemoveArtistaView extends JFrame implements ActionListener {

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<Artista> cboxArtista;

	private JButton btnRemover;
	private JButton btnCancelar;

	// // Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// // a imagem que coloquei no mesmo pacote da main View

	// ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	// JLabel label = new JLabel(imag);

	public RemoveArtistaView() {
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Artista");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
		
		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel();
		}

		lblArtista = new JLabel("Artista que deseja remover:");
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setBackground(AesthethicsView.getCorFundo());
		lblArtista.setFont(AesthethicsView.getFonte());

		cboxArtista = new JComboBox<>(arrayArtistasCadastrados());
		cboxArtista.setBackground(AesthethicsView.getCorFundo());
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setFont(AesthethicsView.getFonteMenor());


		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		// pnlForm.add(label);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}

	//	-------------------------------------------------------------

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
