package main.view.ouvintes;

import main.model.Ouvinte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.removerOuvinteCadastrado;
import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;

public class RemoveOuvinteView extends JFrame implements ActionListener{

	// Instânciando componentes da classe JPanel
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	// Instânciando componentes da classe JLabel
	private JLabel lblTitle;
	private JLabel lblOuvinte;

	// Instânciando um componente da classe JComboBox e colocando a lista de ouvintes
	private JComboBox<Ouvinte> cboxOuvinte;

	// Instânciando componentes da classe JButton
	private JButton btnRemover;
	private JButton btnCancelar;

	// Construtor
	public RemoveOuvinteView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Remover Ouvinte");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblOuvinte = new JLabel("Ouvinte:");
		
		Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(array);

		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);

		return pnlForm;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}
	
//	----------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			
			if(!removerOuvinteCadastrado((Ouvinte) cboxOuvinte.getSelectedItem())) {
				JOptionPane.showMessageDialog(null, "Não foi possível remover o Ouvinte!");
				return;
			}
			
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Ouvinte removido com sucesso!");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
}
