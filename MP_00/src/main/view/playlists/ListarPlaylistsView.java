package main.view.playlists;

import static main.model.Playlist.playlistsCadastradas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.model.Playlist;

public class ListarPlaylistsView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Playlist> lista;
	
	private JButton btnVoltar;

	public ListarPlaylistsView(){
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Playlist");
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
	
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Lista de playlists");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

		DefaultListModel<Playlist> model = new DefaultListModel<Playlist>();
    	lista = new JList<Playlist>(model);

    	for (int i = 0; i < playlistsCadastradas.size(); i++) {
    	    model.add(i, playlistsCadastradas.get(i));
    	}
    	
    	scroll = new JScrollPane(lista);
    	
    	pnlForm.add(scroll);
    	
		return pnlForm;
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
		
		if (src == btnVoltar) {
			this.dispose();
			new PlaylistsView();
		}
	}
	
}
