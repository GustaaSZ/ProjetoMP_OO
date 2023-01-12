package view.ouvintes;

import static model.Ouvinte.ouvintesCadastrados;
import static model.Playlist.playlistsCadastradas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.OuvinteController;
//import model.Artista;
import model.Ouvinte;
import model.Playlist;

public class AdicionarPlaylistsView extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	// Instãnciando componenstes da Classe JPanel
	private JPanel pnlTitle;
	private JPanel pnlForm;
	private JPanel pnlRodape;

	// Instãnciando componenstes da Classe JLabel
	private JLabel lblTitle;
	private JLabel lblPlaylist;
	private JLabel lblOuvinte;

	// Instãnciando componenstes da Classe JComboBox
	private JComboBox<Playlist> cboxPlaylist;
	private JComboBox<Ouvinte> cboxOuvinte;

	// Instãnciando componenstes da Classe JButton
	private JButton btnAdd;
	private JButton btnCancelar;

	// Construtor
	public AdicionarPlaylistsView() {
		inicializar();
	}
	
//	---------------------------------------------------------------------------
	
	// Método inicializar 
	private void inicializar() {
		
		// Título
		setTitle("Adicionar Playlist");
		
		// Definições do tamanho da tela
        setSize(600, 400);
        
        // Ao clicar para fechar a tela, o programa será encerrado
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Ao iniciar o programa, o container e seus respectivos componetes serão direcionados ao centro da tela
        setLocationRelativeTo(null);
        
        // Não permite que o usuário redimensione a tela (Diminuir ou aumentar)
        setResizable(false);
        
        // Tornando visivel a aplicação
        setVisible(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTitle(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        
        btnAdd.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		lblTitle = new JLabel("Adicionar Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(2, 2));
		}

		lblPlaylist = new JLabel("Playlist:");
		lblOuvinte = new JLabel("Ouvinte:");

		Playlist[] array = new Playlist[playlistsCadastradas.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = playlistsCadastradas.get(i);
		}
		cboxPlaylist = new JComboBox<>(array);
		
		Ouvinte[] arrayOuvinte = new Ouvinte[ouvintesCadastrados.size()];
		for (int i = 0; i < arrayOuvinte.length; i++) {
			arrayOuvinte[i] = ouvintesCadastrados.get(i);
		}
		cboxOuvinte = new JComboBox<>(arrayOuvinte);


		pnlForm.add(lblPlaylist);
		pnlForm.add(cboxPlaylist);
		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		

		return pnlForm;
	}
	
	
//	---------------------------------------------------------------------------
	
	public JPanel getPnlRodape() {
		
		if (pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}

		btnAdd = new JButton("Adicionar Playlist");
		btnCancelar = new JButton("Cancelar");

		pnlRodape.add(btnAdd);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}
	
//	---------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnAdd) {
			OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
			if (!controller.adicionarPlaylist((Playlist) cboxPlaylist.getSelectedItem())) {
				JOptionPane.showMessageDialog(null, "Playlist já pertence a Ouvinte!");
				return;
			}
//			controller.adicionarPlaylist((Playlist) cboxPlaylist.getSelectedItem())
			this.dispose();
			new OuvintesView();
			JOptionPane.showMessageDialog(null, "Playlist adicionada com Sucesso!");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
	
	
//	---------------------------------------------------------------------------
	
}
