package main.view.ouvintes;

import main.model.Ouvinte;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.removerOuvinteCadastrado;
import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());
		
    	pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
		return pnlTitle;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(1, 2));
		}

		lblOuvinte = new JLabel("Ouvinte:");
		lblOuvinte.setForeground(AesthethicsView.getCorLetra());
		lblOuvinte.setFont(AesthethicsView.getFonte());
		
		Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(array);
		cboxOuvinte.setForeground(AesthethicsView.getCorLetra());
		cboxOuvinte.setBackground(AesthethicsView.getCorFundoBtn());
		cboxOuvinte.setFont(AesthethicsView.getFonteMenor());

		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		pnlForm.setBackground(AesthethicsView.getCorFundo());

		return pnlForm;
	}
	
//	----------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnRemover = new JButton("Remover");
		btnRemover.setForeground(AesthethicsView.getCorFundo());
		btnRemover.setBackground(AesthethicsView.getCorLetra());
		btnRemover.setFont(AesthethicsView.getFonte());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		

		return pnlRodape;
	}
	
//	----------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			
			if(!removerOuvinteCadastrado((Ouvinte) cboxOuvinte.getSelectedItem())) {
				openDialog("error");
				return;
			}
			
			this.dispose();
			new OuvintesView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
}
