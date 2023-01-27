package main.view.ouvintes;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.ouvintes.DialogOuvintes.openDialog;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.controller.OuvinteController;
import main.components.MyJButton;
import main.components.MyJComboBox;
import main.components.MyJLabel;
import main.components.MyJPanel;

/**
 * Classe view de adicionar playlist no ouvinte, que se relaciona com a classe de OuvinteController
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see OuvinteController
 */
public class AdicionarPlaylistsView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;
    private MyJComboBox<String> cboxOuvinte;

    private MyJButton btnAdd;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe AdicionarPlaylistsView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public AdicionarPlaylistsView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnAdd.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Adicionar Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJComboBox, e tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JComboBox e JLabels instanciados.
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

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */ 
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnAdd = new MyJButton("Adicionar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnAdd);
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

        if (src == btnAdd) {
            OuvinteController controller = new OuvinteController(buscarOuvintePorNome(
            		(String) cboxOuvinte.getSelectedItem()));
            
            if (!controller.adicionarPlaylist(
                    buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
                openDialog("playlist_repetida");
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
