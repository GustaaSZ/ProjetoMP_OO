package main.view.playlists;

import main.model.Musica;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class MusicasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJList<Musica> lista;

    private MyJComboBox<String> cboxPlaylist;

    private MyJButton btnVoltar;

    public MusicasView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnVoltar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Músicas da Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        DefaultListModel<Musica> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < playlistPorIndex(0).getMusicas().size(); i++) {
            model.add(i, playlistPorIndex(0).getMusicas().get(i));
        }

        // Adicionando a a lista no JScrollPane, (Barra de rolagem)
        JScrollPane scroll = new JScrollPane(lista);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        pnlForm.add(cboxPlaylist, BorderLayout.NORTH);
        pnlForm.add(scroll);

        cboxPlaylist.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                var array = buscarPlaylistPorNome(
                        (String) cboxPlaylist.getSelectedItem()).getMusicas().toArray(new Musica[0]);
                if (array.length > 0) {
                    lista.setListData(array);
                } else {
                    lista.setListData(array);
                    openDialog("playlist_vazia");
                }
            }
        });
        return pnlForm;
    }

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnVoltar = new MyJButton("Voltar", true);
        pnlRodape.add(btnVoltar);

        return pnlRodape;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnVoltar) {
            this.dispose();
            new PlaylistsView();
        }
    }
}
