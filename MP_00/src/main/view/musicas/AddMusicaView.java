package main.view.musicas;

import main.model.Artista;
import main.view.components.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.MusicaController.cadastrarMusica;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AddMusicaView extends JFrame implements ActionListener{

	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJTextField txtNome;
	private MyJTextField txtGenero;
	private MyJFormattedTextField txtLancamento;
	private MyJTextArea txtLetra;

	private MyJComboBox<Artista> cboxArtista;
		
	private MyJButton btnCriar;
	private MyJButton btnCancelar;

	public AddMusicaView(){
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnCriar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	public MyJPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
    	}

		MyJLabel lblTitle = new MyJLabel("Cadastro de musicas");
    	pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	public MyJPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new MyJPanel(new GridLayout(5,2), true);
    	}

		MyJLabel lblNome = new MyJLabel("Nome:");
    	txtNome = new MyJTextField(15);

		MyJLabel lblGenero = new MyJLabel("Genero:");
    	txtGenero = new MyJTextField(15);

		MyJLabel lblLancamento = new MyJLabel("Lancamento:");
    	txtLancamento = new MyJFormattedTextField(setMascara());

		MyJLabel lblLetra = new MyJLabel("Letra:");
    	txtLetra = new MyJTextArea();
		JScrollPane scrollPane = new JScrollPane(txtLetra);

		MyJLabel lblArtista = new MyJLabel("Artista:");
    	cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());
    	
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
	
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnCriar = new MyJButton("Cadastrar", true);
    	btnCancelar = new MyJButton("Cancelar", true);

    	pnlRodape.add(btnCriar);
    	pnlRodape.add(btnCancelar);

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
