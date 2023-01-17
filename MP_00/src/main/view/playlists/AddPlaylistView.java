package main.view.playlists;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.model.Ouvinte;
import main.model.Playlist;

public class AddPlaylistView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblOuvinte;
	
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	private JComboBox<Ouvinte> cboxOuvinte;	
		
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddPlaylistView(){
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
        
        btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
	}
	
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Cadastro de Playlist");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(3,2));
    	}
    	
    	lblNome = new JLabel("Nome:");
    	txtNome = new JTextField(15);
    	
    	lblDescricao = new JLabel("Descrição:");
    	txtDescricao = new JTextField(15);
    	
    	
    	lblOuvinte = new JLabel("Ouvinte:");
    	
    	Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = ouvintesCadastrados.get(i);
    	}
    	cboxOuvinte = new JComboBox<>(array);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblDescricao);
    	pnlForm.add(txtDescricao);
    	pnlForm.add(lblOuvinte);
    	pnlForm.add(cboxOuvinte);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Cadastrar");
    	btnCancelar = new JButton("Cancelar");
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			try {
				new Playlist(
					(Ouvinte) cboxOuvinte.getSelectedItem(),
					txtNome.getText().trim(), 
					txtDescricao.getText().trim()
					);
			} catch (Exception e1) {
				openDialog("error");
				return;
			}
			
			this.dispose();
			new PlaylistsView();
			openDialog("success");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new PlaylistsView();
		}
	}
}
