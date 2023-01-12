package view.artistas;

import static model.Artista.artistasCadastrados;
import static view.dialog.Dialog.openDialog;
import static controller.ArtistaController.removerArtistaCadastrado;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Artista;

public class RemoveArtistaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<Artista> cboxArtista;

	private JButton btnRemover;
	private JButton btnCancelar;

	public RemoveArtistaView() {
		inicializar();
	}

	//	-------------------------------------------------------------

	private void inicializar() {
		setTitle("CRUD Artista");
		setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Artista");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel();
		}

		lblArtista = new JLabel("Artista que deseja remover:");

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);

		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);

		return pnlForm;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover Artista");
		btnCancelar = new JButton("Cancelar");

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
