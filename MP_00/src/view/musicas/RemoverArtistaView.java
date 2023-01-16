package view.musicas;

import static controller.MusicaController.buscarMusicaPorNome;
import static model.Musica.musicasCadastradas;
import static view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MusicaController;
import model.Artista;
import model.Musica;

public class RemoverArtistaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

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
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Música");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

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
					pnlForm.remove(cboxArtista);
					
					Musica musicaSelecionada = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
					Artista[] array = new Artista[musicaSelecionada.getArtistas().size()];
					for (int i = 0; i < array.length; i++) {
						array[i] = musicaSelecionada.getArtistas().get(i);
					}
					cboxArtista = new JComboBox<>(array);
					pnlForm.add(cboxArtista);
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
