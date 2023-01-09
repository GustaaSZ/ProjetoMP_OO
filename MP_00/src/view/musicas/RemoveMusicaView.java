package view.musicas;

import static model.Artista.artistasCadastrados;
import static model.Musica.musicasCadastradas;

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
import model.Musica;

public class RemoveMusicaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;

	private JComboBox<Musica> cboxMusica;

	private JButton btnRemover;
	private JButton btnCancelar;

	public RemoveMusicaView() {
		inicializar();
	}

	private void inicializar() {
		setTitle("Criar Musica");
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

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Remover Musica");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblArtista = new JLabel("Musica:");

		Musica[] array = new Musica[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i);
		}
		cboxMusica = new JComboBox<>(array);

		pnlForm.add(lblArtista);
		pnlForm.add(cboxMusica);

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover Musica");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			
			musicasCadastradas.remove((Musica) cboxMusica.getSelectedItem());

			this.dispose();
			new MusicasView();
			JOptionPane.showMessageDialog(null, "Musica removida com sucesso!");
		}

		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}

}
