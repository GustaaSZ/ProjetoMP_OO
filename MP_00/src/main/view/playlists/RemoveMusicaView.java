package main.view.playlists;

import main.controller.PlaylistController;
import main.components.MyJButton;
import main.components.MyJComboBox;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.playlists.DialogPlaylists.openDialog;

/**
 * Classe de remover musica da playlist view, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class RemoveMusicaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnRmv;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe RemoveMusicaView da playlist, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public RemoveMusicaView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnRmv.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Remover Música de alguma Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJComboBox e o MyJLabel. Tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JLabels e JComboBoxs instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2));
        }
        MyJLabel lblPlaylist = new MyJLabel("Playlist:");
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        MyJLabel lblMusica = new MyJLabel("Música:");
        cboxMusica = new MyJComboBox<>(arrayMusicasNaPlaylist(
                playlistPorIndex(0)));

        pnlForm.add(lblPlaylist);
        pnlForm.add(cboxPlaylist);
        pnlForm.add(lblMusica);
        pnlForm.add(cboxMusica);

        cboxPlaylist.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                cboxMusica.removeAllItems();
                var array = arrayMusicasNaPlaylist(
                        buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()));

                for (String musica : array) {
                    cboxMusica.addItem(musica);
                }
            }
        });
        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     *
     * @return Retorna o JPanel da parte inferior com o JButton instanciado.
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnRmv = new MyJButton("Remover", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnRmv);
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

        if (src == btnRmv) {
            PlaylistController controller = new PlaylistController(
                    buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem())
            );

            if (!controller.removerMusica(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()))) {
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
