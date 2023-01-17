package main.view.musicas;

import static main.model.Musica.musicasCadastradas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import main.model.Musica;

public class ListarMusicasView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JScrollPane scroll;
	
	private JLabel lblTitle;
	
	private JList<Musica> lista;
	
	private JButton btnVoltar;

	public ListarMusicasView(){
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Música");
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
    	
    	lblTitle = new JLabel("Lista de Musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	DefaultListModel<Musica> model = new DefaultListModel<Musica>();
    	lista = new JList<Musica>(model);

    	for (int i = 0; i < musicasCadastradas.size(); i++) {
    	    model.add(i, musicasCadastradas.get(i));
		}
    	
		scroll = new JScrollPane(lista);

		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JViewport viewport = scroll.getViewport();
            int w = 400;
            int h = viewport.getPreferredSize().height;
            Dimension preferredSize = new Dimension(w, h);
            viewport.setPreferredSize(preferredSize);

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
			new MusicasView();
		}
	}
	
}
