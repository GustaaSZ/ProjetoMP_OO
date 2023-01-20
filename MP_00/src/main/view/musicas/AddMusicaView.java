package main.view.musicas;

import main.model.Artista;
import main.util.AesthethicsView;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static main.controller.MusicaController.cadastrarMusica;
import static main.model.Artista.artistasCadastrados;
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
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);
		pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
		return pnlTitle;
	}
	
	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(5,2));
    	}
    	
    	lblNome = new JLabel("Nome:");
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setBackground(AesthethicsView.getCorFundo());
		lblNome.setFont(AesthethicsView.getFonte());

    	txtNome = new JTextField(15);
    	txtNome.setBackground(AesthethicsView.getCorFundoBtn());
    	txtNome.setForeground(AesthethicsView.getCorLetra());
		txtNome.setFont(AesthethicsView.getFonteMenor());


    	lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(AesthethicsView.getCorLetra());
		lblGenero.setBackground(AesthethicsView.getCorFundo());
		lblGenero.setFont(AesthethicsView.getFonte());

    	txtGenero = new JTextField(15);
    	txtGenero.setBackground(AesthethicsView.getCorFundoBtn());
    	txtGenero.setForeground(AesthethicsView.getCorLetra());
		txtGenero.setFont(AesthethicsView.getFonteMenor());


    	lblLancamento = new JLabel("Lancamento:");
		lblLancamento.setForeground(AesthethicsView.getCorLetra());
		lblLancamento.setBackground(AesthethicsView.getCorFundo());
		lblLancamento.setFont(AesthethicsView.getFonte());

    	txtLancamento = new JFormattedTextField(setMascara());
		txtLancamento.setBackground(AesthethicsView.getCorFundoBtn());
    	txtLancamento.setForeground(AesthethicsView.getCorLetra());
		txtLancamento.setFont(AesthethicsView.getFonteMenor());
    	
    	lblLetra = new JLabel("Letra:");
		lblLetra.setForeground(AesthethicsView.getCorLetra());
		lblLetra.setBackground(AesthethicsView.getCorFundo());
		lblLetra.setFont(AesthethicsView.getFonte());

    	txtLetra = new JTextArea();
		txtLetra.setBackground(AesthethicsView.getCorFundoBtn());
    	txtLetra.setForeground(AesthethicsView.getCorLetra());
		txtLetra.setFont(AesthethicsView.getFonteMenor());

		txtLetra.setLineWrap(true);
    	
		scrollPane = new JScrollPane(txtLetra);

    	lblArtista = new JLabel("Artista:");
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setBackground(AesthethicsView.getCorFundo());
		lblArtista.setFont(AesthethicsView.getFonte());
    	
    	Artista[] array = new Artista[artistasCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
    	    array[i] = artistasCadastrados.get(i);
    	}
    	cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setBackground(AesthethicsView.getCorFundoBtn());
    	
		pnlForm.setBackground(AesthethicsView.getCorFundo());
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
		btnCriar.setForeground(AesthethicsView.getCorFundo());
		btnCriar.setBackground(AesthethicsView.getCorLetra());
		btnCriar.setFont(AesthethicsView.getFonte());

    	btnCancelar = new JButton("Cancelar");
    	btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonte());


    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
		return pnlRodape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnCriar) {
			if (!cadastrarMusica(
					(Artista) cboxArtista.getSelectedItem(),
					txtNome.getText(),
					txtLetra.getText(),
					txtGenero.getText(),
					txtLancamento.getText())) {
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
	
	private MaskFormatter setMascara(){
	    MaskFormatter mask = null;
	    try{
	        mask = new MaskFormatter("##/##/####");
	    }catch(ParseException ex){
	    	ex.printStackTrace();
	    }
	    return mask;
	}
}
