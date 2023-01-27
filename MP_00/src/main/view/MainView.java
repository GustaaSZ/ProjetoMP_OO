package main.view;

import main.util.Inicializacao;
import main.view.artistas.ArtistasView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;
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
import static main.view.Dialog.openDialog;

/**
 * Classe MainView que representa a tela principal do sistema.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class MainView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJButton btnArtistas;
    private MyJButton btnMusicas;
    private MyJButton btnPlaylists;
    private MyJButton btnOuvintes;
    private MyJButton btnFechar;

    /**
     * Construtor da classe MainView, chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public MainView() {
        inicializar(this, "Sistema de Músicas", getPnlTitle(), getPnlBody(), getPnlRodape());

        btnArtistas.addActionListener(this);
        btnMusicas.addActionListener(this);
        btnPlaylists.addActionListener(this);
        btnOuvintes.addActionListener(this);
        btnFechar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a parte superior da tela Principal
     *
     * @return Retorna o JPanel da parte superior da tela com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Projeto Orientação à Objetos");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton.
       Tem como objetivo editar a parte central da tela principal.
     *
     * @return Retorna o JPanel do body com os JButtons instanciados.
     */
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

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a parte inferior da tela Principal
     *
     * @return Retorna o JPanel da parte inferior com o JButton instanciado.
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnFechar = new MyJButton("Fechar Programa", true);
        pnlRodape.add(btnFechar);

        return pnlRodape;
    }

    /**
     * Listener para os JButtons
     *
     * @param e está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */
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
