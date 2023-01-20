package main.view.ouvintes;

import main.controller.OuvinteController;
import main.model.Ouvinte;
import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class UpdateOuvinteView extends JFrame implements ActionListener{
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblOuvinte;
	
	private JTextField txtNome;
	
	private JComboBox<Ouvinte> cboxOuvinte;
	
	private JButton btnUpdt;
	private JButton btnCancelar;


	public UpdateOuvinteView(){
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Atualizar Ouvinte");
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
		
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(2,2));
    	}
    	
    	lblNome = new JLabel("Nome: ");
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setFont(AesthethicsView.getFonte());

    	txtNome = new JTextField(20);
		txtNome.setBackground(AesthethicsView.getCorFundoBtn());
		txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());

		txtNome.setText(ouvintesCadastrados.get(0).getNome());
    	
    	Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = ouvintesCadastrados.get(i);
    	}
    	
    	lblOuvinte = new JLabel("Ouvinte:");
		lblOuvinte.setForeground(AesthethicsView.getCorLetra());
		lblOuvinte.setFont(AesthethicsView.getFonte());

    	cboxOuvinte = new JComboBox<>(array);
		cboxOuvinte.setForeground(AesthethicsView.getCorLetra());
		cboxOuvinte.setBackground(AesthethicsView.getCorFundoBtn());
		cboxOuvinte.setFont(AesthethicsView.getFonteMenor());
    	
    	pnlForm.add(lblOuvinte);
    	pnlForm.add(cboxOuvinte);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		pnlForm.setBackground(AesthethicsView.getCorFundo());
		
		cboxOuvinte.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Ouvinte selected = (Ouvinte) cboxOuvinte.getSelectedItem();
				txtNome.setText(selected.getNome());
				}
			});

		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnUpdt = new JButton("Atualizar");
		btnUpdt.setForeground(AesthethicsView.getCorFundo());
		btnUpdt.setBackground(AesthethicsView.getCorLetra());
		btnUpdt.setFont(AesthethicsView.getFonte());
		

    	btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());

    	
    	pnlRodape.add(btnUpdt);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
		return pnlRodape;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnUpdt) {
			OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
			controller.editarNome(txtNome.getText().trim());
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