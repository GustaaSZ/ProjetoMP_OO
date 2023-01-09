package view.ouvintes;

import static model.Ouvinte.ouvintesCadastrados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainView;

public class OuvintesView implements ActionListener{
	
	private JFrame ouvinteView = new JFrame("Gerenciamento de ouvintes");
	
	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnVoltar;

	public OuvintesView() {
        inicializar();
    }

    private void inicializar() {
        ouvinteView.setSize(600, 400);
        ouvinteView.setLocationRelativeTo(null);
        ouvinteView.setResizable(false);
        ouvinteView.setVisible(true);
        
        ouvinteView.getContentPane().setLayout(new BorderLayout());
        ouvinteView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        ouvinteView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
        ouvinteView.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
        btnVoltar.addActionListener(this);
    }
    
    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnAdd = new JButton("Cadastrar ouvinte");
    	btnRemove = new JButton("Remover ouvinte");
    	btnUpdate = new JButton("Atualizar ouvinte");
    	btnList = new JButton("Listar ouvintes");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	
		return pnlBody;
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
		
		if (src == btnAdd) {
				ouvinteView.dispose();
//				new AddouvinteView();
		}
		
		if (src == btnRemove) {
			if (ouvintesCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um ouvinte primeiro!");
				return;
			}
			ouvinteView.dispose();
//			new RemoveOuvintesView();
		}
		
		if (src == btnUpdate) {
			if (ouvintesCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um ouvinte primeiro!");
				return;
			}
			ouvinteView.dispose();
//			new UpdateOuvintesView();
		}
		
		if (src == btnList) {
			if (ouvintesCadastrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Cadastre um ouvinte primeiro!");
				return;
			}
			ouvinteView.dispose();
//			new ListarOuvintesView();
		}
		
		if (src == btnVoltar) {
			ouvinteView.dispose();
			new MainView();
		}
	}
}
