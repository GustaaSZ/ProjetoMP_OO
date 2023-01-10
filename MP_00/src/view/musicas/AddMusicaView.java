package view.musicas;

import static model.Artista.artistasCadastrados;
import static model.Musica.musicasCadastradas;
import static util.Conversor.stringToDate;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Artista;
import model.LetraMusica;
import model.Musica;

public class AddMusicaView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;
	
	private JLabel lblTitle;
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblLancamento;
	private JLabel lblLetra;
	private JLabel lblArtista;
	
	private JTextField txtNome;
	private JTextField txtGenero;
	private JFormattedTextField txtLancamento;
	private JTextField txtLetra;
	
	private JComboBox<Artista> cboxArtista;	
		
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddMusicaView(){
		inicializar();
	}

	private void inicializar() {
		setTitle("Criar Musica");
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
	
	
	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(5,2));
    	}
    	
    	lblNome = new JLabel("Nome");
    	txtNome = new JTextField(15);
    	
    	lblGenero = new JLabel("Genero");
    	txtGenero = new JTextField(15);
    	
    	lblLancamento = new JLabel("Lancamento");
    	txtLancamento = new JFormattedTextField(setMascara("##/##/####"));
    	
    	lblLetra = new JLabel("Letra");
    	txtLetra = new JTextField(20);
    	
    	lblArtista = new JLabel("Artista");
    	
    	Artista[] array = new Artista[artistasCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = artistasCadastrados.get(i);
    	}
    	cboxArtista = new JComboBox<>(array);
    	
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	pnlForm.add(lblGenero);
    	pnlForm.add(txtGenero);
    	pnlForm.add(lblLancamento);
    	pnlForm.add(txtLancamento);
    	pnlForm.add(lblLetra);
    	pnlForm.add(txtLetra);
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Criar Musica");
    	btnCancelar = new JButton("Cancelar");
    	
    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			try {
				new Musica(
					(Artista) cboxArtista.getSelectedItem(),
					txtNome.getText().trim(), 
					new LetraMusica(txtLetra.getText()), 
					txtGenero.getText().trim(), 
					stringToDate(txtLancamento.getText())
					);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			this.dispose();
			new MusicasView();
			JOptionPane.showMessageDialog(null, "Musica cadastrada com sucesso!");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new MusicasView();
		}
	}
	
	private MaskFormatter setMascara(String mascara){
	    MaskFormatter mask = null;
	    try{
	        mask = new MaskFormatter(mascara);                      
	    }catch(ParseException ex){
	    	ex.printStackTrace();
	    }
	    return mask;
	}
}
