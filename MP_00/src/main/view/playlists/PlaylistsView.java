package main.view.playlists;

import main.view.MainView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.isMusicasEmpty;
import static main.controller.PlaylistController.isPlaylistsEmpty;
import static main.util.Inicializacao.inicializar;
import static main.view.playlists.DialogPlaylists.openDialog;

/**
 * Classe de playlists view, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class PlaylistsView extends JFrame implements ActionListener {
    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJButton btnAdd;
    private MyJButton btnRemove;
    private MyJButton btnUpdate;
    private MyJButton btnList;
    private MyJButton btnMusicas;
    private MyJButton btnAddMusica;
    private MyJButton btnRmvMusica;
    private MyJButton btnVoltar;

    /**
     * Construtor da classe PlaylistsView da playlist, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public PlaylistsView() {
        inicializar(this, "CRUD Playlist", getPnlTitle(), getPnlBody(), getPnlRodape());

        // REGISTRA O EVENTO
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
        btnMusicas.addActionListener(this);
        btnAddMusica.addActionListener(this);
        btnRmvMusica.addActionListener(this);
        btnVoltar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Crud de Playlists");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel e os MyJButtons. Tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JButtons instanciados.
     */
    public MyJPanel getPnlBody() {
        if (pnlBody == null) {
            pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        btnAdd = new MyJButton("Cadastrar playlist");
        btnRemove = new MyJButton("Remover playlist");
        btnUpdate = new MyJButton("Atualizar playlist");
        btnList = new MyJButton("Listar Playlists");
        btnMusicas = new MyJButton("Listar Músicas da Playlist");
        btnAddMusica = new MyJButton("Adicionar música na playlist");
        btnRmvMusica = new MyJButton("Remover música da playlist");

        pnlBody.add(btnAdd);
        pnlBody.add(btnRemove);
        pnlBody.add(btnUpdate);
        pnlBody.add(btnList);
        pnlBody.add(btnMusicas);
        pnlBody.add(btnAddMusica);
        pnlBody.add(btnRmvMusica);

        return pnlBody;
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
        btnVoltar = new MyJButton("Voltar", true);
        pnlRodape.add(btnVoltar);

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

        if (src == btnAdd) {
            this.dispose();
            new AddPlaylistView();
        }

        if (src == btnRemove) {
            if (isPlaylistsEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new RemovePlaylistView();
        }

        if (src == btnUpdate) {
            if (isPlaylistsEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new UpdatePlaylistView();
        }

        if (src == btnList) {
            if (isPlaylistsEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new ListarPlaylistsView();
        }

        if (src == btnMusicas) {
            if (isPlaylistsEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new MusicasView();
        }

        if (src == btnAddMusica) {
            if (isPlaylistsEmpty() || isMusicasEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new AddMusicaView();
        }

        if (src == btnRmvMusica) {
            if (isPlaylistsEmpty() || isMusicasEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new RemoveMusicaView();
        }

        if (src == btnVoltar) {
            this.dispose();
            new MainView();
        }
    }
}
