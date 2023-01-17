package main.view.musicas;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.view.dialog.Dialog.openDialog;
import static main.util.Conversor.dateToString;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import main.controller.MusicaController;
import main.model.Musica;

public class UpdateMusicaView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblMusica;
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblLancamento;
	private JLabel lblLetra;

	private JTextField txtNome;
	private JTextField txtGenero;
	private JFormattedTextField txtLancamento;
	private JTextArea txtLetra;

	private JComboBox<String> cboxMusica;

	private JButton btnUpdt;
	private JButton btnCancelar;

	public UpdateMusicaView() {
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

		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Atualizar Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(5, 5));
		}

		String[] array = new String[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i).getNome();
		}

		lblMusica = new JLabel("Música:");
		cboxMusica = new JComboBox<>(array);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);
		txtNome.setText(cboxMusica.getSelectedItem().toString());

		lblGenero = new JLabel("Genero:");
		txtGenero = new JTextField(15);
		txtGenero.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()).getGenero());

		lblLancamento = new JLabel("Lancamento:");
		txtLancamento = new JFormattedTextField(setMascara("##/##/####"));
		txtLancamento.setText(dateToString(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()).getLancamento()));

		lblLetra = new JLabel("Letra:");
		txtLetra = new JTextArea();
		txtLetra.setLineWrap(true);
		txtLetra.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()).getLetra());

		pnlForm.add(lblMusica);
		pnlForm.add(cboxMusica);
		pnlForm.add(lblNome);
		pnlForm.add(txtNome);
		pnlForm.add(lblGenero);
		pnlForm.add(txtGenero);
		pnlForm.add(lblLancamento);
		pnlForm.add(txtLancamento);
		pnlForm.add(lblLetra);
		pnlForm.add(txtLetra);

		cboxMusica.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
					txtNome.setText(selected.getNome());
					txtGenero.setText(selected.getGenero());
					txtLancamento.setText(dateToString(selected.getLancamento()));
					txtLetra.setText(selected.getLetra());
				}
			}
		});

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnUpdt = new JButton("Atualizar");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnUpdt);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnUpdt) {

			Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());

			MusicaController controller = new MusicaController(selected);
			controller.atualizarMusica(
					txtNome.getText(), 
					txtGenero.getText(), 
					txtLancamento.getText(),
					txtLetra.getText());
			this.dispose();
			new MusicasView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return mask;
	}
}
