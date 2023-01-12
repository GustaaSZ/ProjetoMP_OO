package view.musicas;

import static controller.MusicaController.buscarMusicaPorNome;
import static model.Musica.musicasCadastradas;
import static view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.MusicaController;
import model.Musica;

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
	private JTextField txtLetra;

	private JComboBox<String> cboxMusica;

	private JButton btnUpdt;
	private JButton btnCancelar;

	public UpdateMusicaView() {
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Música");
		setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		lblNome = new JLabel("Nome");
		txtNome = new JTextField(20);

		lblGenero = new JLabel("Genero");
		txtGenero = new JTextField(15);

		lblLancamento = new JLabel("Lancamento");
		txtLancamento = new JFormattedTextField(setMascara("##/##/####"));

		lblLetra = new JLabel("Letra");
		txtLetra = new JTextField(20);

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

		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnUpdt = new JButton("Atualizar Música");
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
