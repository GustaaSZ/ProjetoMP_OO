package view.ouvintes;

import static view.dialog.Dialog.openDialog;
import static view.dialog.Dialog.objetoEncontrado;
import static controller.OuvinteController.buscarOuvintePorNome;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ouvinte;

public class BuscarOuvinte extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	
	private JTextField txtNome;
	
	
	private JButton btnBuscar;
	private JButton btnCancelar;

	public BuscarOuvinte(){
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Ouvinte");
        setSize(600, 400);
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
	}
	
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Buscar Artista");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	lblNome = new JLabel("Nome:");
    	txtNome = new JTextField(20);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnBuscar = new JButton("Buscar");
    	btnCancelar = new JButton("Voltar");
    	
    	btnBuscar.setSize(30, 50);
    	
    	pnlRodape.add(btnBuscar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnBuscar) {
			if(txtNome.getText() == null || txtNome.getText().trim() == "") {
				openDialog("error");
			}
			
			Ouvinte ouvinte = buscarOuvintePorNome(txtNome.getText());

			if (ouvinte.equals(null)) {
				openDialog("ouvinte_nao_encontradado");
				return;
			} else {
				objetoEncontrado(ouvinte);
				return;
			}
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
}
