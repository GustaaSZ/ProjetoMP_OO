package main.view.musicas;

import main.model.Artista;
import main.model.Musica;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static main.model.Artista.artistasCadastrados;
import static main.util.Conversor.stringToDate;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class AddMusicaView extends JFrame implements ActionListener{

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
	private JTextArea txtLetra;

	private JScrollPane scrollPane;

	private JComboBox<Artista> cboxArtista;	
		
	private JButton btnCriar;
	private JButton btnCancelar;

	public AddMusicaView(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Cadastro de musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(5,2));
    	}
    	
    	lblNome = new JLabel("Nome:");
    	txtNome = new JTextField(15);
    	
    	lblGenero = new JLabel("Genero:");
    	txtGenero = new JTextField(15);
    	
    	lblLancamento = new JLabel("Lancamento:");
    	txtLancamento = new JFormattedTextField(setMascara("##/##/####"));
    	
    	lblLetra = new JLabel("Letra:");
    	txtLetra = new JTextArea();
		txtLetra.setLineWrap(true);
    	
		scrollPane = new JScrollPane(txtLetra);

    	lblArtista = new JLabel("Artista:");
    	
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
    	pnlForm.add(scrollPane);
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	
		return pnlForm;
	}
	
	public JPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new JButton("Cadastrar");
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
					txtLetra.getText().trim(), 
					txtGenero.getText().trim(), 
					stringToDate(txtLancamento.getText())
					);
			} catch (Exception e1) {
				openDialog("error");
				return;
			}
			
			this.dispose();
			new MusicasView();
			openDialog("success");
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
