package view.ouvintes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ouvinte;

public class AddOuvintesView extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	// Instânciando componentes da classe JLabel (textos)
	private JLabel lblTitle;
	private JLabel lblNome;
	
	// Instânciando componentes da classe JTextField (Campo de texto)
	private JTextField txtNome;
	
	// Instânciando componentes da classe JButton, que por sua vez são botões
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddOuvintesView(){
		inicializar();
	}
	
//	-----------------------------------------------------------------------------
	
	private void inicializar() {
		
		setTitle("Criar Ouvinte");
        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
//	-----------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
		
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
//	-----------------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		
    	if (pnlForm == null) {
    		pnlForm = new JPanel();
    	}
    	
    	// Definindo a mensagem que irá aparecer no JLabel lblNome
    	lblNome = new JLabel("Nome:");
    	// Definindo o tamanho do campo de texto
    	txtNome = new JTextField(20);
    	
    	// Add os componentes ao JPanel pnlForm
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		return pnlForm;
	}
	
//	-----------------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		// Definindo a mensagem que irá aparecer no btnCriar
		btnCriar = new JButton("Criar Ouvinte");
		// Definindo a mensagem que irá aparecer no btnCancelar
    	btnCancelar = new JButton("Cancelar");
    	
    	// Altura e largura do botão de criar
    	btnCriar.setSize(30, 50);
    	
    	// Add os componentes ao JPanel pnlRodape
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}
	
//	-----------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// O método getsource() obtém a origem do evento
		Object src = e.getSource();
		
		if (src == btnCriar) {
			
			// Se ao tentar criar um ouvinte, o usuário não digitar nada...Irá aparecer a seguinte mensagem
			if(txtNome.getText() == null || txtNome.getText().trim() == "") {
				
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar Ouvinte!");
			}
			// Ao sair da condição, ele cadastra o ouvinte
			new Ouvinte( txtNome.getText().trim());
			//new Ouvinte(null, txtNome.getText().trim(), null);
//			System.out.println(ouvintesCadastrados.get(0));
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Ouvinte Cadastrado com Sucesso!");
		}
		
		// Se o usuário clicar em cancelar, o programa deve voltar para a tela inicial
		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
//	-----------------------------------------------------------------------------
	
}

