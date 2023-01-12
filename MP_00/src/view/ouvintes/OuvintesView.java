package view.ouvintes;

import static model.Ouvinte.ouvintesCadastrados;
import static model.Playlist.playlistsCadastradas;
import static view.dialog.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MainView;

public class OuvintesView implements ActionListener{
	
	private JFrame ouvinteView = new JFrame("Gerenciamento de ouvintes");
	
	private JPanel pnlTitle;
	private JPanel pnlBody;
	private JPanel pnlRodape;

	private JLabel lblTitle;

	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnList;
	private JButton btnListPlaylists;
	private JButton btnVoltar;

	public OuvintesView() {
        inicializar();
    }

    private void inicializar() {
    	ouvinteView.setTitle("Gerenciamento de Ouvintes");
        ouvinteView.setSize(600, 400);
        ouvinteView.setLocationRelativeTo(null);
        ouvinteView.setResizable(false);
        ouvinteView.setVisible(true);
        
        ouvinteView.getContentPane().setLayout(new BorderLayout());
        ouvinteView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        ouvinteView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
        ouvinteView.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnListPlaylists.addActionListener(this);
        btnList.addActionListener(this);
        btnVoltar.addActionListener(this);
    }
    
    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Ouvintes");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnAdd = new JButton("Adicionar Ouvinte");
    	btnRemove = new JButton("Remover Ouvinte");
    	btnUpdate = new JButton("Atualizar Ouvinte");
    	btnList = new JButton("Listar Ouvintes");
    	btnListPlaylists = new JButton("Listar Playlists do Ouvinte");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnListPlaylists);
    	
		return pnlBody;
	}
    
    public JPanel getPnlRodape() {
    	
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		
		btnVoltar = new JButton("Voltar");
    	
    	pnlRodape.add(btnVoltar);
		
		return pnlRodape;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btnAdd) {
				ouvinteView.dispose();
				new AddOuvintesView();
		}
		
		if (src == btnRemove) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			ouvinteView.dispose();
			new RemoveOuvinteView();
		}
		
		if (src == btnUpdate) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			ouvinteView.dispose();
			new UpdateOuvinteView();
		}
		
		if (src == btnList) {
			if (ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			ouvinteView.dispose();
			new ListarOuvintesView();
		}
//		----------------- Adicionada aqui essa funcionalidade --------------------
		if(src == btnListPlaylists) {
			if(playlistsCadastradas.isEmpty() || ouvintesCadastrados.isEmpty()) {
				openDialog("ouvinte");
				return;
			}
			ouvinteView.dispose();
			new ListarPlaylistsOuvinteView();
		}
		
		
		if (src == btnVoltar) {
			ouvinteView.dispose();
			new MainView();
		}
		
	}
}
