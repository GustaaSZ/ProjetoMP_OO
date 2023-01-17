package main.view.musicas;

import static main.model.Musica.musicasCadastradas;
import static main.view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.view.MainView;

public class MusicasView implements ActionListener {

	private JFrame musicaView = new JFrame("Gerenciamento de Músicas");

	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnVoltar;
	private JButton btnAddArt;
	private JButton btnRmvArt;
	private JButton btnLetra;

	public MusicasView() {
		inicializar();
	}

	private void inicializar() {
		musicaView.setSize(600, 400);
		musicaView.setLocationRelativeTo(null);
		musicaView.setResizable(false);
		musicaView.setVisible(true);
		musicaView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		musicaView.getContentPane().setLayout(new BorderLayout());
		musicaView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		musicaView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
		musicaView.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnAddArt.addActionListener(this);
		btnRmvArt.addActionListener(this);
		btnLetra.addActionListener(this);
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
		btnAddArt = new JButton("Adicionar artista na Música");
		btnRmvArt = new JButton("Remover artista da Música");
		btnLetra = new JButton("Ver letra da Música");

		pnlBody.add(btnAdd);
		pnlBody.add(btnRemove);
		pnlBody.add(btnUpdate);
		pnlBody.add(btnList);
		pnlBody.add(btnLetra);
		pnlBody.add(btnAddArt);
		pnlBody.add(btnRmvArt);

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
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new RemoveMusicaView();
		}

		if (src == btnUpdate) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new UpdateMusicaView();
		}

		if (src == btnList) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new ListarMusicasView();
		}
		
		if (src == btnAddArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new AdicionarArtistasView();
		}

		if (src == btnRmvArt) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new RemoverArtistaView();
		}

		if (src == btnLetra) {
			if (musicasCadastradas.isEmpty()) {
				openDialog("musica");
				return;
			}
			musicaView.dispose();
			new LetraView();
		}

		if (src == btnVoltar) {
			musicaView.dispose();
			new MainView();
		}
	}
}
