package view.musicas;

import static model.Musica.musicasCadastradas;
import static controller.MusicaController.buscarMusicaPorNome;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Musica;

public class LetraView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	private JLabel lblTitle;
	private JLabel lblMusica;
	private JLabel lblLetra;

	private JComboBox<String> cboxMusica;

	private JButton btnVoltar;

	public LetraView() {
		inicializar();
	}

	//	-------------------------------------------------------------

	private void inicializar() {
		setTitle("CRUD Musica");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnVoltar.addActionListener(this);
	}

	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Letra da Música");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new BorderLayout());
		}

		lblMusica = new JLabel("Musica:");
		
		pnlForm.add(lblMusica, BorderLayout.NORTH);

		String[] array = new String[musicasCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = musicasCadastradas.get(i).getNome();
		}
		cboxMusica = new JComboBox<>(array);

		pnlForm.add(cboxMusica, BorderLayout.NORTH);

		Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
		
		lblLetra = new JLabel(selected.getLetra());
		pnlForm.add(lblLetra, BorderLayout.CENTER);
		lblLetra.setBorder(border);
		
		cboxMusica.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Musica selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
					lblLetra.setText(selected.getLetra());
				}
			}
		});
		return pnlForm;
	}

	//	-------------------------------------------------------------

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnVoltar = new JButton("Voltar");

		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnVoltar) {
			this.dispose();
			new MusicasView();
		}
	}

	Border border = new Border() {
		@Override
		public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
			g.drawRect(x, y, width - 1, height - 1);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public Insets getBorderInsets(Component arg0) {
			return new Insets(1, 1, 1, 1);
		}
	};
}
