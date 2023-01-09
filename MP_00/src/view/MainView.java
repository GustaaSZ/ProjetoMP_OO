package view;

import static model.Artista.artistasCadastrados;
import static model.Ouvinte.ouvintesCadastrados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.artistas.ArtistasView;
import view.musicas.MusicasView;
import view.ouvintes.OuvintesView;
import view.playlists.PlaylistsView;

public class MainView implements ActionListener{
	
	private static JFrame telaPrincipal = new JFrame("Crud Musicas");
	private JPanel pnlTitle;
	private JPanel pnlBody;
	
	private JLabel lblTitle;
	
	private JButton btnArtistas;
	private JButton btnMusicas;
	private JButton btnPlaylists;
	private JButton btnOuvintes;
	private JButton btnFechar;
	
	public MainView() {
		inicializar();
	}
	
	private void inicializar() {
		telaPrincipal.setSize(600, 400);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setLocationRelativeTo(null);
		telaPrincipal.setResizable(false);
		telaPrincipal.setVisible(true);
        
		telaPrincipal.getContentPane().setLayout(new BorderLayout());
		telaPrincipal.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
		telaPrincipal.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
        
        btnArtistas.addActionListener(this);
        btnMusicas.addActionListener(this);
        btnPlaylists.addActionListener(this);
        btnOuvintes.addActionListener(this);
        btnFechar.addActionListener(this);
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
    	
    	btnMusicas = new JButton("Gerenciar Musicas");
    	btnArtistas = new JButton("Gerenciar Artistas");
    	btnPlaylists = new JButton("Gerenciar Playlists");
    	btnOuvintes = new JButton("Gerenciar Ouvintes");
    	btnFechar = new JButton("Fechar Programa");
    	
    	pnlBody.add(btnArtistas);
    	pnlBody.add(btnMusicas);
    	pnlBody.add(btnPlaylists);
    	pnlBody.add(btnOuvintes);
    	pnlBody.add(btnFechar);
    	
		return pnlBody;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnArtistas) {
			telaPrincipal.dispose();
			new ArtistasView();
		}
		
		if (src == btnMusicas) {
			if (artistasCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "cadastre um artista primeiro");
				return;
			}
			telaPrincipal.dispose();
			new MusicasView();	
		}
		
		if (src == btnPlaylists) {
			if (ouvintesCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "cadastre um ouvinte primeiro");
				return;
			}
			telaPrincipal.dispose();
			new PlaylistsView();
		}
		
		if (src == btnOuvintes) {
			telaPrincipal.dispose();
			new OuvintesView();
		}
		
		if (src == btnFechar) {
			System.exit(0);
		}
	}

}
