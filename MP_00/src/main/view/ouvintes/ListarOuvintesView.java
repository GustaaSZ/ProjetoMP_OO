package main.view.ouvintes;

import main.model.Ouvinte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarOuvintesView extends JFrame implements ActionListener{

	// Instânciando objetos da classe JPanel
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	// Instânciando objeto da classe JLabel
	private JLabel lblTitle;
	
	// Instânciando objeto da classe JList, onde irá pegar uma lista de ouvintes
	private JList<Ouvinte> lista;
	
	// Instânciando objeto da classe JButton
	private JButton btnVoltar;

	// Construtor
	public ListarOuvintesView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnVoltar.addActionListener(this);
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Lista de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}

    	DefaultListModel<Ouvinte> model = new DefaultListModel<Ouvinte>();
    	lista = new JList<Ouvinte>(model);

    	for (int i = 0; i < ouvintesCadastrados.size(); i++) {
    	    model.add(i, ouvintesCadastrados.get(i));
    	}
    	
    	pnlForm.add(lista);
    	
		return pnlForm;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	
    	pnlRodape.add(btnVoltar);
		
		return pnlRodape;
	}
	
//	----------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnVoltar) {
			this.dispose();
			new OuvintesView();
		}
	}
}

