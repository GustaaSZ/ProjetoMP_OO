package view.artistas;

import static model.Artista.artistasCadastrados;
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

public class ArtistasView implements ActionListener {

	private static JFrame artistaView = new JFrame("Crud de Artistas");

	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnListMusicas;
	private JButton btnVoltar;

	public ArtistasView() {
		inicializar();
	}

	private void inicializar() {
		artistaView.setTitle("Gerenciamento de Artistas");
		artistaView.setSize(600, 400);
		artistaView.setLocationRelativeTo(null);
		artistaView.setResizable(false);
		artistaView.setVisible(true);

		artistaView.getContentPane().setLayout(new BorderLayout());
		artistaView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		artistaView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
		artistaView.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnListMusicas.addActionListener(this);
		btnVoltar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Crud de Artistas");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}

	public JPanel getPnlBody() {
		if (pnlBody == null) {
			pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Cadastrar Artista");
		btnRemove = new JButton("Remover Artista");
		btnUpdate = new JButton("Atualizar Artista");
		btnList = new JButton("Listar Artistas");
		btnListMusicas = new JButton("Listar M??sicas do Artista");

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnListMusicas);

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
			artistaView.dispose();
			new AddArtistasView();
		}

		if (src == btnRemove) {
			if (artistasCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um artista primeiro!");
				return;
			}
			artistaView.dispose();
			new RemoveArtistaView();
		}

		if (src == btnUpdate) {
			if (artistasCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um artista primeiro!");
				return;
			}
			artistaView.dispose();
			new UpdateArtistaView();
		}

		if (src == btnList) {
			if (artistasCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um artista primeiro!");
				return;
			}
			artistaView.dispose();
			new ListarArtistasView();
		}
		
		if (src == btnListMusicas) {
			if (musicasCadastradas.isEmpty() || artistasCadastrados.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Cadastre uma m??sica e um artista primeiro!");
//				return;
			}
			artistaView.dispose();
			new ListarMusicasArtistaView();
		}

		if (src == btnVoltar) {
			artistaView.dispose();
			new MainView();
		}
	}

}
