package main.view.artistas;

import main.controller.ArtistaController;
import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static main.model.Artista.artistasCadastrados;
import static main.util.Inicializacao.inicializar;
import static main.view.dialog.Dialog.openDialog;

public class UpdateArtistaView extends JFrame implements ActionListener{


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
		inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

		btnUpdt.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	//	-------------------------------------------------------------

	public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Artistas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
	
	//	-------------------------------------------------------------

	public JPanel getPnlForm() {
    	if (pnlForm == null) {
    		pnlForm = new JPanel(new GridLayout(3,2));
    	}
    	
    	Artista[] array = new Artista[artistasCadastrados.size()];
    	for(int i = 0; i < array.length; i++) {
			array[i] = artistasCadastrados.get(i);
    	}
    	lblArtista = new JLabel("Artista:");
    	cboxArtista = new JComboBox<>(array);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);
		txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
    	
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
    	
		cboxArtista.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
					}
				}
		});
		return pnlForm;
	}

	//	-------------------------------------------------------------
	
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

	//	-------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnUpdt) {

			ArtistaController controller = new ArtistaController((Artista) cboxArtista.getSelectedItem());
			controller.editarNome(txtNome.getText().trim());
			
			this.dispose();
			new ArtistasView();
			openDialog("success");
		}
		
		if (src == btnCancelar) {
			this.dispose();
			new ArtistasView();
		}
	}
	
}
