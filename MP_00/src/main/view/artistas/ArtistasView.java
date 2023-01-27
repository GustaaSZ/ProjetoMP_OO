package main.view.artistas;


import main.util.Inicializacao;
import main.view.MainView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.isArtistasEmpty;
import static main.controller.MusicaController.isMusicasEmpty;
import static main.util.Inicializacao.inicializar;
import static main.view.artistas.DialogArtistas.openDialog;

/**
 * Classe com a view principal de artistas.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class ArtistasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJLabel lblTitle;

    private MyJButton btnAdd;
    private MyJButton btnRemove;
    private MyJButton btnUpdate;
    private MyJButton btnList;
    private MyJButton btnListMusicas;
    private MyJButton btnBuscar;
    private MyJButton btnVoltar;

    /**
     * Construtor da classe, chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public ArtistasView() {
        inicializar(this, "CRUD Artistas", getPnlTitle(), getPnlBody(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
        btnListMusicas.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnVoltar.addActionListener(this);
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a parte superior da tela
     *
     * @return Retorna o JPanel da parte inferior com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        lblTitle = new MyJLabel("Crud de Artistas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JButtons instanciados.
     */
    public MyJPanel getPnlBody() {
        if (pnlBody == null) {
            pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        btnAdd = new MyJButton("Cadastrar Artista");
        btnRemove = new MyJButton("Remover Artista");
        btnUpdate = new MyJButton("Atualizar Artista");
        btnList = new MyJButton("Listar Artistas");
        btnBuscar = new MyJButton("Buscar Artista");
        btnListMusicas = new MyJButton("Listar Músicas do Artista");

        pnlBody.add(btnAdd);
        pnlBody.add(btnRemove);
        pnlBody.add(btnUpdate);
        pnlBody.add(btnList);
        pnlBody.add(btnBuscar);
        pnlBody.add(btnListMusicas);

        return pnlBody;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a parte inferior da tela
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
     * @param (ActionEvent e). Está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdd) {
            this.dispose();
            new AddArtistasView();
        }

        if (src == btnRemove) {
            if (isArtistasEmpty()) {
                openDialog("artista");
                return;
            }
            this.dispose();
            new RemoveArtistaView();
        }

        if (src == btnUpdate) {
            if (isArtistasEmpty()) {
                openDialog("artista");
                return;
            }
            this.dispose();
            new UpdateArtistaView();
        }

        if (src == btnList) {
            if (isArtistasEmpty()) {
                openDialog("artista");
                return;
            }
            this.dispose();
            new ListarArtistasView();
        }

        if (src == btnBuscar) {
            if (isArtistasEmpty()) {
                openDialog("artista");
                return;
            }
            this.dispose();
            new BuscarArtistaView();
        }

        if (src == btnListMusicas) {
            if (isMusicasEmpty() || isArtistasEmpty()) {
                openDialog("artista_musica");
                return;
            }
            this.dispose();
            new ListarMusicasArtistaView();
        }

        if (src == btnVoltar) {
            this.dispose();
            new MainView();
        }
    }


}
