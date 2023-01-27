package main.view.ouvintes;

import main.controller.OuvinteController;
// import main.model.Ouvinte;
import main.components.MyJButton;
import main.components.MyJComboBox;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.arrayPlaylistsPorOuvinte;
import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.ouvintes.DialogOuvintes.openDialog;

/**
 * Classe view de remover playlists do ouvinte, que se relaciona com os método
   de removerPlaylist, buscarOuvintePorNome e arrayPlaylistsPorOuvinte
   das classes OuvinteController e PlaylistController
 * 
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see OuvinteController
 */
public class RemoverPlaylistsView extends JFrame implements ActionListener {

	// Instãnciando componenstes da Classe MyJPanel
	private MyJPanel pnlTitle;
	private MyJPanel pnlForm;
	private MyJPanel pnlRodape;

	private MyJComboBox<String> cboxPlaylist;
	private MyJComboBox<String> cboxOuvinte;

	private MyJButton btnRemover;
	private MyJButton btnCancelar;

	/**
     * Construtor da classe RemoveOuvinteView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
	public RemoverPlaylistsView() {
		inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
		// REGISTRA OS EVENTOS
		btnRemover.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	/**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte inferior com o JLabel instanciado.
     */
	public MyJPanel getPnlTitle() {
		if (pnlTitle == null) {
			pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		// Instãnciando componenstes da Classe MyJLabel
		MyJLabel lblTitle = new MyJLabel("Remover Playlist");
		pnlTitle.add(lblTitle);

		return pnlTitle;
	}
	
	/**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJComboBox, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com o JLabel e o JComboBox instanciados.
     */
	public MyJPanel getPnlForm() {
		if (pnlForm == null) {
			pnlForm = new MyJPanel(new GridLayout(2, 2));
		}
		MyJLabel lblPlaylist = new MyJLabel("Playlist:");
		MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");

		cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());
		cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

		pnlForm.add(lblOuvinte);
		pnlForm.add(cboxOuvinte);
		pnlForm.add(lblPlaylist);
		pnlForm.add(cboxPlaylist);

		cboxOuvinte.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cboxPlaylist.removeAllItems();

				var array = arrayPlaylistsPorOuvinte(buscarOuvintePorNome(
	            		(String) cboxOuvinte.getSelectedItem()));
				for (int i = 0; i < array.length; i++) {
					cboxPlaylist.addItem(
							buscarOuvintePorNome(
			                		(String) cboxOuvinte.getSelectedItem()).getPlaylists().get(i).getNome());
				}
			}
		});

		return pnlForm;
	}
	
	/**
     * Método que instância objetos das classes MyJPanel e MyJButton, tem como objetivo editar a tela na parte inferior
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */
	public MyJPanel getPnlRodape() {
		if (pnlRodape == null) {
			pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnRemover = new MyJButton("Remover", true);
		btnCancelar = new MyJButton("Cancelar", true);

		pnlRodape.add(btnRemover);
		pnlRodape.add(btnCancelar);

		return pnlRodape;
	}
	
	/**
     * Listener para os JButtons
     *
     * @param (ActionEvent e), está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRemover) {
			OuvinteController controller = new OuvinteController(buscarOuvintePorNome(
            		(String) cboxOuvinte.getSelectedItem()));
			if (!controller.removerPlaylist(
					buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
				openDialog("error");
				return;
			}
			this.dispose();
			new OuvintesView();
			openDialog("success");
		}

		if (src == btnCancelar) {
			this.dispose();
			new OuvintesView();
		}
	}
}
