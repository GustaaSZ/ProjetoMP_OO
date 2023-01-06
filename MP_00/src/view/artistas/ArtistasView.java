package view.artistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MainView;

public class ArtistasView implements ActionListener{
	
	private static JFrame artistaView = new JFrame("Crud de Artistas");
	protected JPanel pnlTitle;
	protected JPanel pnlBody;
	
	private JLabel lblTitle;
	
	protected JButton btnAdd;
	protected JButton btnRemove;
	protected JButton btnUpdate;
	protected JButton btnList;
	protected JButton btnVoltar;
	

	public ArtistasView() {
        inicializar();
    }

    private void inicializar() {
        artistaView.setTitle("Gerenciamento de Artistas");
        artistaView.setSize(600, 400);
        artistaView.setLocationRelativeTo(null);
        artistaView.setResizable(false);
        artistaView.setVisible(true);
        
        artistaView.getContentPane().setLayout(new BorderLayout());
        artistaView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        artistaView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
        
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
        btnVoltar.addActionListener(this);
    }
    
    public JPanel getPnlTitle() {
    	if (pnlTitle == null) {
    		pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	lblTitle = new JLabel("Crud de Artistas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnAdd = new JButton("Adicionar Artista");
    	btnRemove = new JButton("Remover Artista");
    	btnUpdate = new JButton("Atualizar Artista");
    	btnList = new JButton("Listar Artistas");
    	btnVoltar = new JButton("Voltar");
    	
    	pnlBody.add(btnAdd);
    	pnlBody.add(btnRemove);
    	pnlBody.add(btnUpdate);
    	pnlBody.add(btnList);
    	pnlBody.add(btnVoltar);
    	
		return pnlBody;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
Object src = e.getSource();
		
		if (src == btnAdd) {
			artistaView.dispose();
//			new AddArtistaView();
		}
		
		if (src == btnRemove) {
			artistaView.dispose();
//			new RemoveMusicasView();
		}
		
		if (src == btnUpdate) {
			artistaView.dispose();
//			new UpdateMusicasView();
		}
		
		if (src == btnList) {
			artistaView.dispose();
//			new ListMusicasView();
		}
		
		if (src == btnVoltar) {
			artistaView.dispose();
			new MainView();
		}
	}

}
