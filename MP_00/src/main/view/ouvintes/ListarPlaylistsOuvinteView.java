package main.view.ouvintes;

import main.model.Ouvinte;
import main.model.Playlist;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.arrayPlaylistsPorOuvinte;
import static main.model.Ouvinte.ouvintesCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarPlaylistsOuvinteView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<Ouvinte> cboxOuvinte;

    private MyJList<Playlist> lista;

    private MyJButton btnVoltar;

    public ListarPlaylistsOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnVoltar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Lista de Playlists do Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout(), true);
        }
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        DefaultListModel<Playlist> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < ouvintesCadastrados.get(0).getPlaylists().size(); i++) {
            model.add(i, ouvintesCadastrados.get(0).getPlaylists().get(i));
        }

        pnlForm.add(cboxOuvinte, BorderLayout.NORTH);
        pnlForm.add(lista, BorderLayout.CENTER);

        cboxOuvinte.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lista.setListData(
                        arrayPlaylistsPorOuvinte((Ouvinte) cboxOuvinte.getSelectedItem()));
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
            new OuvintesView();
        }
    }

}
