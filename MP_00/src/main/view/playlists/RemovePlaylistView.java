package main.view.playlists;

import main.components.MyJButton;
import main.components.MyJComboBox;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.playlists.DialogPlaylists.openDialog;

/**
 * Classe de remover uma playlist view, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class RemovePlaylistView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;

    private MyJButton btnRemover;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe RemovePlaylistView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public RemovePlaylistView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnRemover.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a parte superior da tela
     *
     * @return Retorna o JPanel da parte superior da tela com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Remover Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJComboBox e o MyJLabel. Tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com o JLabel e JComboBox instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(1, 2));
        }
        MyJLabel lblArtista = new MyJLabel("Playlist:");
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        pnlForm.add(lblArtista);
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

            if (!removerPlaylist(buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
                openDialog("playlist_not_null");
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
