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

import controller.MusicaController;
import model.Artista;
import model.Musica;

public class AdicionarArtistasView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblArtista;
	private JLabel lblMusica;

	private JComboBox<Artista> cboxArtista;
	private JComboBox<Musica> cboxMusica;

	private JButton btnAdd;
	private JButton btnCancelar;

	public AdicionarArtistasView() {
		inicializar();
	}

	private void inicializar() {
		setTitle("Adicionar artista");
		setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Adicionar Artista");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}

		lblArtista = new JLabel("Artista:");
		lblMusica = new JLabel("Música:");

		Artista[] array = new Artista[artistasCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
		}
		cboxArtista = new JComboBox<>(array);
		
		Musica[] arrayMusica = new Musica[musicasCadastradas.size()];
		for (int i = 0; i < arrayMusica.length; i++) {
			arrayMusica[i] = musicasCadastradas.get(i);
		}
		cboxMusica = new JComboBox<>(arrayMusica);


		pnlForm.add(lblArtista);
		pnlForm.add(cboxArtista);
		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Adicionar Artista");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			MusicaController controller = new MusicaController((Musica) cboxMusica.getSelectedItem());
			if (!controller.adicionarArtista((Artista) cboxArtista.getSelectedItem())) {
				JOptionPane.showMessageDialog(null, "Artista já pertence a música!");
				return;
			}
			
			this.dispose();
			new MusicasView();
			JOptionPane.showMessageDialog(null, "Artista adicionado com sucesso!");
		}

		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}

}
