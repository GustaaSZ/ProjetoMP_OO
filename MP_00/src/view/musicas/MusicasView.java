package view.musicas;

import static model.Musica.musicasCadastradas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainView;

public class MusicasView implements ActionListener {

	private JFrame musicaView = new JFrame("Gerenciamento de Musicas");

	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnVoltar;

	public MusicasView() {
		inicializar();
	}

	private void inicializar() {
		musicaView.setSize(600, 400);
		musicaView.setLocationRelativeTo(null);
		musicaView.setResizable(false);
		musicaView.setVisible(true);

		musicaView.getContentPane().setLayout(new BorderLayout());
		musicaView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		musicaView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
		musicaView.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnVoltar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Crud de musicas");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Cadastrar Musica");
		btnRemove = new JButton("Remover Musica");
		btnUpdate = new JButton("Atualizar Musica");
		btnList = new JButton("Listar Musicas");

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);

		return pnlBody;
	}

	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnVoltar = new JButton("Voltar");

		pnlRodape.add(btnVoltar);

		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			musicaView.dispose();
			new AddMusicaView();
		}

		if (src == btnRemove) {
			if (musicasCadastradas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre uma música primeiro!");
				return;
			}
			musicaView.dispose();
			new RemoveMusicaView();
		}

		if (src == btnUpdate) {
			if (musicasCadastradas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre uma música primeiro!");
				return;
			}
			musicaView.dispose();
//			new UpdateMusicasView();
		}

		if (src == btnList) {
			if (musicasCadastradas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre uma música primeiro!");
				return;
			}
			musicaView.dispose();
			new ListarMusicasView();
		}

		if (src == btnVoltar) {
			musicaView.dispose();
			new MainView();
		}
	}
}
