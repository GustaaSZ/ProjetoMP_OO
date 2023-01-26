package main.view.playlists;

import main.controller.PlaylistController;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view de adicionar ouvintes, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see  PlaylistController
 */
public class AddMusicaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnAdd;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe AddMusicaView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public AddMusicaView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA O EVENTO
        btnAdd.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte superior com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Adicionar Música");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJomboBox, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JLabels e JComboBox instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2));
        }
        MyJLabel lblPlaylist = new MyJLabel("Playlist:");
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        MyJLabel lblMusica = new MyJLabel("Música:");
        cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

        pnlForm.add(lblPlaylist);
        pnlForm.add(cboxPlaylist);
        pnlForm.add(lblMusica);
        pnlForm.add(cboxMusica);

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

            PlaylistController controller = new PlaylistController(
                    buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())
            );

            if (!controller.adicionarMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
                openDialog("error");
                return;
            }

            this.dispose();
            new PlaylistsView();
            openDialog("success");
        }

        if (src == btnCancelar) {
            this.dispose();
            new PlaylistsView();
        }
    }
}
