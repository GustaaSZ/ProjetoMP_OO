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
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoveMusicaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnRmv;
    private MyJButton btnCancelar;

    public RemoveMusicaView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnRmv.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Remover Música de alguma Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

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
