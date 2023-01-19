package main.view.artistas;

import main.controller.ArtistaController;
import main.model.Artista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

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

	//	CORES
	Font fonte = new Font("Courier New", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);

	// ----- Cinza escuro -------
	Color corFundoBtn = new Color(54, 54, 54);

	// ------- Verde forte ---------
	Color fonteLetra = new Color(50, 205, 50);

	// ---- Preto escuro ------
	Color corFundo = new Color(28 ,28 ,28);

	// Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// a imagem que coloquei no mesmo pacote da main View

	ImageIcon imag = new ImageIcon(getClass().getResource("imagem7.jpg"));
	JLabel label = new JLabel(imag);

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
		//    	Mudando a cor da letra
		lblTitle.setForeground(fonteLetra);

    	pnlTitle.add(lblTitle);
		//		Mudando a cor do btn
    	pnlTitle.setBackground(corFundo);
    	
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
		lblArtista.setForeground(fonteLetra);

    	cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(fonteLetra);
		cboxArtista.setBackground(corFundo);

		lblNome = new JLabel("Nome:");
		lblNome.setForeground(fonteLetra);

		txtNome = new JTextField(20);
		txtNome.setBackground(corFundo);
		txtNome.setForeground(fonteLetra);

		txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
    	
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		pnlForm.add(label);

		pnlForm.setBackground(corFundo);
    	
		cboxArtista.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
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
		btnUpdt.setForeground(corFundo);
		btnUpdt.setBackground(fonteLetra);

    	btnCancelar = new JButton("Cancelar");
    	btnCancelar.setForeground(corFundo);
		btnCancelar.setBackground(fonteLetra);

    	pnlRodape.add(btnUpdt);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(corFundo);
		
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
