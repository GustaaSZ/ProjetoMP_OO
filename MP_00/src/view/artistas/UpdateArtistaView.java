package view.artistas;

import static model.Artista.artistasCadastrados;

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
import javax.swing.JTextField;

import controller.ArtistaController;
import model.Artista;

public class UpdateArtistaView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblArtista;
	
	private JTextField txtNome;
	
	private JComboBox<Artista> cboxArtista;
	
	private JButton btnUpdt;
	private JButton btnCancelar;


	public UpdateArtistaView(){
		inicializar();
	}

	private void inicializar() {
		setTitle("Criar Artista");
        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    	
    	lblTitle = new JLabel("Crud de Artistas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(2,2));
    	}
    	
    	lblNome = new JLabel("Nome");
    	txtNome = new JTextField(20);
    	
    	Artista[] array = new Artista[artistasCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = artistasCadastrados.get(i);
    	}
    	
    	lblArtista = new JLabel("Artista:");
    	cboxArtista = new JComboBox<>(array);
    	
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnUpdt = new JButton("Atualizar Artista");
    	btnCancelar = new JButton("Cancelar");
    	
    	pnlRodape.add(btnUpdt);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnUpdt) {

			ArtistaController controller = new ArtistaController((Artista) cboxArtista.getSelectedItem());
			controller.editarNome(txtNome.getText().trim());
//			System.out.println(artistasCadastrados.get(0));
			this.dispose();
			new ArtistasView();
			JOptionPane.showMessageDialog(null, "Artista atualizado com sucesso!");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
