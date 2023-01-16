package view.ouvintes;

import static model.Ouvinte.ouvintesCadastrados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.OuvinteController;
import model.Ouvinte;

public class UpdateOuvinteView extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
	
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
		inicializar();
	}

	private void inicializar() {
		setTitle("CRUD Ouvintes");
        setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
	}

	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Atualizar Ouvinte");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(2,2));
    	}
    	
    	lblNome = new JLabel("Nome: ");
    	txtNome = new JTextField(20);
		txtNome.setText(ouvintesCadastrados.get(0).getNome());
    	
    	Ouvinte[] array = new Ouvinte[ouvintesCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = ouvintesCadastrados.get(i);
    	}
    	
    	lblOuvinte = new JLabel("Ouvinte:");
    	cboxOuvinte = new JComboBox<>(array);
    	
    	pnlForm.add(lblOuvinte);
    	pnlForm.add(cboxOuvinte);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		
		cboxOuvinte.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Ouvinte selected = (Ouvinte) cboxOuvinte.getSelectedItem();
					txtNome.setText(selected.getNome());
					}
				}
		});

		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnUpdt = new JButton("Atualizar");
    	btnCancelar = new JButton("Cancelar");
    	
    	pnlRodape.add(btnUpdt);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnUpdt) {

			OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
			controller.editarNome(txtNome.getText().trim());
//			System.out.println(artistasCadastrados.get(0));
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Ouvinte Atualizado com Sucesso!");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
}