package main.view.ouvintes;

import main.view.TelaPrincipal;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.isOuvintesEmpty;
import static main.controller.PlaylistController.isPlaylistsEmpty;
import static main.util.Inicializacao.inicializar;
import static main.view.ouvintes.DialogOuvintes.openDialog;

/**
 * Classe view de Ouvintes, que se relaciona com a classe de OuvinteController, em específico com o método siOuvintesEmpty
   em específico com o método de buscarOuvintePorNome
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see isOuvintesEmpty OuvinteController
 */
public class OuvintesView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJButton btnAdd;
    private MyJButton btnRemove;
    private MyJButton btnUpdate;
    private MyJButton btnList;
    private MyJButton btnBuscar;
    private MyJButton btnAddPlaylist;
    private MyJButton btnRmvPlaylist;
    private MyJButton btnListPlaylists;
    private MyJButton btnVoltar;

    /**
     * Construtor da classe OuvintesView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public OuvintesView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlBody(), getPnlRodape());

        // REGISTRA OS EVENTOS
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnListPlaylists.addActionListener(this);
        btnList.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnAddPlaylist.addActionListener(this);
        btnRmvPlaylist.addActionListener(this);
        btnVoltar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Crud de Ouvintes");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JButtons instanciados.
     */
    public MyJPanel getPnlBody() {
        if (pnlBody == null) {
            pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        btnAdd = new MyJButton("Adicionar Ouvinte");
        btnRemove = new MyJButton("Remover Ouvinte");
        btnUpdate = new MyJButton("Atualizar Ouvinte");
        btnList = new MyJButton("Listar Ouvintes");
        btnBuscar = new MyJButton("Buscar Ouvinte");
        btnAddPlaylist = new MyJButton("Adicionar Playlist");
        btnRmvPlaylist = new MyJButton("Remover Playlist");
        btnListPlaylists = new MyJButton("Listar Playlists do Ouvinte");

        pnlBody.add(btnAdd);
        pnlBody.add(btnRemove);
        pnlBody.add(btnUpdate);
        pnlBody.add(btnList);
        pnlBody.add(btnBuscar);
        pnlBody.add(btnAddPlaylist);
        pnlBody.add(btnRmvPlaylist);
        pnlBody.add(btnListPlaylists);

        return pnlBody;
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
            new AddOuvintesView();
        }

        if (src == btnRemove) {
            if (isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new RemoveOuvinteView();
        }

        if (src == btnUpdate) {
            if (isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new UpdateOuvinteView();
        }

        if (src == btnList) {
            if (isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new ListarOuvintesView();
        }

        if (src == btnListPlaylists) {
            if (isPlaylistsEmpty() || isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new ListarPlaylistsOuvinteView();
        }

        if (src == btnAddPlaylist) {
            if (isPlaylistsEmpty() || isOuvintesEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new AdicionarPlaylistsView();
        }

        if (src == btnRmvPlaylist) {
            if (isPlaylistsEmpty() || isOuvintesEmpty()) {
                openDialog("playlist");
                return;
            }
            this.dispose();
            new RemoverPlaylistsView();
        }

        if (src == btnBuscar) {
            if (isPlaylistsEmpty() || isOuvintesEmpty()) {
                openDialog("ouvinte");
                return;
            }
            this.dispose();
            new BuscarOuvinteView();
        }

        if (src == btnVoltar) {
            this.dispose();
            new TelaPrincipal();
        }

    }
}
