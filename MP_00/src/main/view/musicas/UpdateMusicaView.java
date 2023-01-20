package main.view.musicas;

import main.controller.MusicaController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.util.Conversor.dateToString;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class UpdateMusicaView extends JFrame implements ActionListener {

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
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
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

		lblMusica = new JLabel("Música:");
		cboxMusica = new JComboBox<>(arrayMusicasCadastradas());

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

		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				var selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
				txtNome.setText(selected.getNome());
				txtGenero.setText(selected.getGenero());
				txtLancamento.setText(dateToString(selected.getLancamento()));
				txtLetra.setText(selected.getLetra());
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
			MusicaController controller = new MusicaController(
					buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
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
