package view.ouvintes;

import static model.Ouvinte.ouvintesCadastrados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Ouvinte;

public class ListarOuvintesView extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
	

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
		inicializar();
	}
	
//	----------------------------------------------------------------------
	
	// Método inicializar 
	private void inicializar() {
		
		// Título
		setTitle("Criar Ouvinte");
		
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

