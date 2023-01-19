package main.view.artistas;

import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.removerArtistaCadastrado;
import static main.model.Artista.artistasCadastrados;
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

	//	CORES
	Font fonte = new Font("Courier New", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);

	// ----- Cinza escuro -------
	Color corFundoBtn = new Color(54, 54, 54);

	// ------- Verde forte ---------
	Color fonteLetra = new Color(50, 205, 50);

	// ---- Preto escuro ------
	Color corFundo = new Color(28 ,28 ,28);

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
	JLabel label = new JLabel(imag);

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
		lblTitle.setForeground(fonteLetra);
		
		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(corFundo);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel();
		}

		lblArtista = new JLabel("Artista que deseja remover:");
		lblArtista.setForeground(fonteLetra);
		lblArtista.setBackground(corFundo);

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);
		cboxArtista.setBackground(corFundo);


		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		pnlForm.add(label);
		pnlForm.setBackground(corFundo);

		return pnlForm;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnRemover.setForeground(fonteLetra);
		btnRemover.setBackground(corFundoBtn);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(corFundo);
		btnCancelar.setBackground(fonteLetra);

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(corFundo);

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
