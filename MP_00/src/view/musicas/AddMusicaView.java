package view.musicas;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Musica;

public class AddMusicaView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	protected JPanel pnlTitle;
	protected JPanel pnlForm;
	protected JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblLancamento;
	private JLabel lblLetra;
	private JLabel lblArtista;
	
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtLancamento;
	private JTextField txtLetra;
	private JTextField txtArtista;	
		
	protected JButton btnCriar;
	protected JButton btnCancelar;

	public AddMusicaView(){
		inicializar();
	}

	private void inicializar() {
		setTitle("Criar Musica");
        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
	}
	
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(5,2));
    	}
    	
    	lblNome = new JLabel("Nome");
    	txtNome = new JTextField(20);
    	
    	lblGenero = new JLabel("Genero");
    	txtGenero = new JTextField(20);
    	
    	lblLancamento = new JLabel("Lancamento");
    	txtLancamento = new JTextField(10);
    	
    	lblLetra = new JLabel("Letra");
    	txtLetra = new JTextField(20);
    	
    	lblArtista = new JLabel("Artista");
    	txtArtista = new JTextField(20);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblGenero);
    	pnlForm.add(txtGenero);
    	pnlForm.add(lblLancamento);
    	pnlForm.add(txtLancamento);
    	pnlForm.add(lblLetra);
    	pnlForm.add(txtLetra);
    	pnlForm.add(lblArtista);
    	pnlForm.add(txtArtista);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Criar Musica");
    	btnCancelar = new JButton("Cancelar");
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			
//			new Musica(null, title, null, title, null);
			
			this.dispose();
			new MusicasView();
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}
	
}
