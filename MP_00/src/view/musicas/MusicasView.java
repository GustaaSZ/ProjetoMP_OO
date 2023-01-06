package view.musicas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static model.Artista.artistasCadastrados;

import view.MainView;

public class MusicasView implements ActionListener{
	
	private JFrame musicaView = new JFrame("Gerenciamento de Musicas");
	protected JPanel pnlTitle;
	protected JPanel pnlBody;
	
	private JLabel lblTitle;
	
	protected JButton btnAdd;
	protected JButton btnRemove;
	protected JButton btnUpdate;
	protected JButton btnList;
	protected JButton btnVoltar;

	public MusicasView() {
        inicializar();
    }

    private void inicializar() {
        musicaView.setSize(600, 400);
        musicaView.setLocationRelativeTo(null);
        musicaView.setResizable(false);
        musicaView.setVisible(true);
        
        musicaView.getContentPane().setLayout(new BorderLayout());
        musicaView.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        musicaView.getContentPane().add(getPnlBody(), BorderLayout.CENTER);
        
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
    	
    	lblTitle = new JLabel("Crud de musicas");
    	pnlTitle.add(lblTitle);
    	
		return pnlTitle;
	}
    
    public JPanel getPnlBody() {
    	if (pnlBody == null) {
    		pnlBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	}
    	
    	btnAdd = new JButton("Adicionar Musica");
    	btnRemove = new JButton("Remover Musica");
    	btnUpdate = new JButton("Atualizar Musica");
    	btnList = new JButton("Listar Musicas");
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
			if (artistasCadastrados.size() > 0) {
				musicaView.dispose();
				new AddMusicaView();
			} else {
				//nao tem artista cadastrado
			}
		}
		
		if (src == btnRemove) {
			musicaView.dispose();
//			new RemoveMusicasView();
		}
		
		if (src == btnUpdate) {
			musicaView.dispose();
//			new UpdateMusicasView();
		}
		
		if (src == btnList) {
			musicaView.dispose();
//			new ListMusicasView();
		}
		
		if (src == btnVoltar) {
			musicaView.dispose();
			new MainView();
		}
	}
}
