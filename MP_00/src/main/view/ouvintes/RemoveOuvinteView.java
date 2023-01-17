package main.view.ouvintes;

import static main.controller.OuvinteController.removerOuvinteCadastrado;
import static main.model.Ouvinte.ouvintesCadastrados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.model.Ouvinte;

public class RemoveOuvinteView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

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
		inicializar();
	}
	
//	---------------------------------------------------------------------------
	
	// Método inicializar 
	private void inicializar() {
		
		// Título
		setTitle("CRUD Ouvintes");
		
		// Definições do tamanho da tela
        setSize(600, 400);
        
        // Ao clicar para fechar a tela, o programa será encerrado
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Ao iniciar o programa, o container e seus respectivos componetes serão direcionados ao centro da tela
        setLocationRelativeTo(null);
        
        // Não permite que o usuário redimensione a tela (Diminuir ou aumentar)
        setResizable(false);
        
        // Tornando visivel a aplicação
        setVisible(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
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
