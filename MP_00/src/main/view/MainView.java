package main.view;

import main.view.artistas.ArtistasView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.musicas.MusicasView;
import main.view.ouvintes.OuvintesView;
import main.view.playlists.PlaylistsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.isArtistasEmpty;
import static main.controller.OuvinteController.isOuvintesEmpty;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class MainView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJButton btnArtistas;
    private MyJButton btnMusicas;
    private MyJButton btnPlaylists;
    private MyJButton btnOuvintes;
    private MyJButton btnFechar;

//	ImageIcon imag = new ImageIcon(getClass().getResource("imagem.jpg"));
//	MyJLabel label = new MyJLabel(imag);

    public MainView() {
        inicializar(this, "Sistema de Músicas", getPnlTitle(), getPnlBody(), getPnlRodape());

        btnArtistas.addActionListener(this);
        btnMusicas.addActionListener(this);
        btnPlaylists.addActionListener(this);
        btnOuvintes.addActionListener(this);
        btnFechar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Projeto Orientação à Objetos");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlBody() {
        if (pnlBody == null) {
            pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        btnMusicas = new MyJButton("Gerenciar Musicas");
        btnArtistas = new MyJButton("Gerenciar Artistas");
        btnOuvintes = new MyJButton("Gerenciar Ouvintes");
        btnPlaylists = new MyJButton("Gerenciar Playlists");

        pnlBody.add(btnArtistas);
        pnlBody.add(btnMusicas);
        pnlBody.add(btnOuvintes);
        pnlBody.add(btnPlaylists);

        return pnlBody;
    }

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnFechar = new MyJButton("Fechar Programa", true);
        pnlRodape.add(btnFechar);

        return pnlRodape;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnArtistas) {
            this.dispose();
            new ArtistasView();
        }

        if (src == btnMusicas) {
            if (isArtistasEmpty()) {
                openDialog("artista");
                return;
            }
            this.dispose();
            new MusicasView();
        }

        if (src == btnOuvintes) {
            this.dispose();
            new OuvintesView();
        }

        if (src == btnPlaylists) {
            if (isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new PlaylistsView();
        }

        if (src == btnFechar) {
            System.exit(0);
        }
    }

}
