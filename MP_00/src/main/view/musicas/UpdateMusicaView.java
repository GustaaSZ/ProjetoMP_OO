package main.view.musicas;

import main.controller.MusicaController;
import main.model.Musica;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.model.Musica.musicasCadastradas;
import static main.util.Conversor.dateToString;
import static main.util.Inicializacao.inicializar;
import main.util.AesthethicsView;
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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

		pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());

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
		lblMusica.setFont(AesthethicsView.getFonte());
		lblMusica.setForeground(AesthethicsView.getCorLetra());

		cboxMusica = new JComboBox<>(array);
		cboxMusica.setForeground(AesthethicsView.getCorLetra());
		cboxMusica.setBackground(AesthethicsView.getCorFundoBtn());
		cboxMusica.setFont(AesthethicsView.getFonteMenor());

		lblNome = new JLabel("Nome:");
		lblNome.setFont(AesthethicsView.getFonte());
		lblNome.setForeground(AesthethicsView.getCorLetra());

		txtNome = new JTextField(20);
		txtNome.setBackground(AesthethicsView.getCorFundoBtn());
		txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());

		txtNome.setText(cboxMusica.getSelectedItem().toString());

		lblGenero = new JLabel("Genero:");
		lblGenero.setBackground(AesthethicsView.getCorFundoBtn());
		lblGenero.setForeground(AesthethicsView.getCorLetra());
		lblGenero.setFont(AesthethicsView.getFonte());

		txtGenero = new JTextField(15);
		txtGenero.setBackground(AesthethicsView.getCorFundoBtn());
		txtGenero.setForeground(AesthethicsView.getCorLetra());
		txtGenero.setFont(AesthethicsView.getFonteMenor());

		txtGenero.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()).getGenero());

		lblLancamento = new JLabel("Lancamento:");
		lblLancamento.setBackground(AesthethicsView.getCorFundoBtn());
		lblLancamento.setForeground(AesthethicsView.getCorLetra());
		lblLancamento.setFont(AesthethicsView.getFonte());

		txtLancamento = new JFormattedTextField(setMascara("##/##/####"));
		txtLancamento.setForeground(AesthethicsView.getCorLetra());
		txtLancamento.setBackground(AesthethicsView.getCorFundoBtn());
		txtLancamento.setFont(AesthethicsView.getFonteMenor());

		txtLancamento.setText(dateToString(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()).getLancamento()));

		lblLetra = new JLabel("Letra:");
		lblLetra.setBackground(AesthethicsView.getCorFundoBtn());
		lblLetra.setForeground(AesthethicsView.getCorLetra());
		lblLetra.setFont(AesthethicsView.getFonte());

		txtLetra = new JTextArea();
		txtLetra.setForeground(AesthethicsView.getCorLetra());
		txtLetra.setBackground(AesthethicsView.getCorFundoBtn());
		txtLetra.setFont(AesthethicsView.getFonteMenor());

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
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		cboxMusica.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
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
		btnUpdt.setForeground(AesthethicsView.getCorFundo());
		btnUpdt.setBackground(AesthethicsView.getCorLetra());
		btnUpdt.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnUpdt);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		

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
