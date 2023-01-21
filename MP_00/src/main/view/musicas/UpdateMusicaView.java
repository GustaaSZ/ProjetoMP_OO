package main.view.musicas;

import main.controller.MusicaController;
import main.view.components.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.util.Conversor.dateToString;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class UpdateMusicaView extends JFrame implements ActionListener {

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJTextField txtNome;
	private MyJTextField txtGenero;
	private MyJFormattedTextField txtLancamento;
	private MyJTextArea txtLetra;

	private MyJComboBox<String> cboxMusica;

	private MyJButton btnUpdt;
	private MyJButton btnCancelar;

	public UpdateMusicaView() {
		inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		MyJLabel lblTitle = new MyJLabel("Atualizar Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(5, 5), true);
		}

		MyJLabel lblMusica = new MyJLabel("Música:");
		cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

		MyJLabel lblNome = new MyJLabel("Nome:");
		txtNome = new MyJTextField(20);
		txtNome.setText(musicasCadastradas.get(0).getNome());

		MyJLabel lblGenero = new MyJLabel("Genero:");
		txtGenero = new MyJTextField(15);
		txtGenero.setText(musicasCadastradas.get(0).getGenero());

		MyJLabel lblLancamento = new MyJLabel("Lancamento:");
		txtLancamento = new MyJFormattedTextField(setMascara());
		txtLancamento.setText(dateToString(musicasCadastradas.get(0).getLancamento()));

		MyJLabel lblLetra = new MyJLabel("Letra:");
		txtLetra = new MyJTextArea();
		txtLetra.setLineWrap(true);
		txtLetra.setText(musicasCadastradas.get(0).getLetra());

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

	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnUpdt = new MyJButton("Atualizar");
		btnCancelar = new MyJButton("Cancelar");

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

	private MaskFormatter setMascara() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("##/##/####");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return mask;
	}
}
