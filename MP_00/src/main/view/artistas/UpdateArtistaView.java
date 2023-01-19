package main.view.artistas;

import main.controller.ArtistaController;
import main.model.Artista;
import main.util.AesthethicsView;

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

	// // Instanciando um objeto imag da Classe ImageIcon, e passando como argumento
	// // a imagem que coloquei no mesmo pacote da main View

	// ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
	// JLabel label = new JLabel(imag);

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
		//    	Mudando a cor da letra e a fonte
		lblTitle.setForeground(AesthethicsView.getCorLetra());
		lblTitle.setFont(AesthethicsView.getFonte());

    	pnlTitle.add(lblTitle);

		//		Mudando a cor de fundo do Title
    	pnlTitle.setBackground(AesthethicsView.getCorFundoBtn());
    	
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
		lblArtista.setFont(AesthethicsView.getFonte());
		lblArtista.setForeground(AesthethicsView.getCorLetra());
		lblArtista.setFont(AesthethicsView.getFonte());

    	cboxArtista = new JComboBox<>(array);
		cboxArtista.setForeground(AesthethicsView.getCorLetra());
		cboxArtista.setBackground(AesthethicsView.getCorFundo());
		cboxArtista.setFont(AesthethicsView.getFonteMenor());

		lblNome = new JLabel("Nome:");
		lblNome.setFont(AesthethicsView.getFonte());
		lblNome.setForeground(AesthethicsView.getCorLetra());
		lblNome.setFont(AesthethicsView.getFonte());

		txtNome = new JTextField(20);
		txtNome.setBackground(AesthethicsView.getCorFundo());
		txtNome.setForeground(AesthethicsView.getCorLetra());

		txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
    	
    	pnlForm.add(lblArtista);
    	pnlForm.add(cboxArtista);
    	pnlForm.add(lblNome);
    	pnlForm.add(txtNome);
		// pnlForm.add(label);

		pnlForm.setBackground(AesthethicsView.getCorFundo());
    	
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
		btnUpdt.setForeground(AesthethicsView.getCorFundo());
		btnUpdt.setBackground(AesthethicsView.getCorLetra());
		btnUpdt.setFont(AesthethicsView.getFonteMenor());

    	btnCancelar = new JButton("Cancelar");
    	btnCancelar.setForeground(AesthethicsView.getCorFundo());
		btnCancelar.setBackground(AesthethicsView.getCorLetra());
		btnCancelar.setFont(AesthethicsView.getFonteMenor());

    	pnlRodape.add(btnUpdt);
    	pnlRodape.add(btnCancelar);
		pnlRodape.setBackground(AesthethicsView.getCorFundoBtn());
		
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
