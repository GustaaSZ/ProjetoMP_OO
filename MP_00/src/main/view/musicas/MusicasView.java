package main.view.musicas;

import main.view.MainView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.isMusicasEmpty;
import static main.util.Inicializacao.inicializar;
import static main.view.musicas.DialogMusicas.openDialog;

/**
 * Classe view MusicasView, que se relaciona com a classe de musicaController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see isMusicasEmpty MusicaController
 */
public class MusicasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlBody;
    private MyJPanel pnlRodape;

    private MyJButton btnAdd;
    private MyJButton btnRemove;
    private MyJButton btnUpdate;
    private MyJButton btnList;
    private MyJButton btnVoltar;
    private MyJButton btnAddArt;
    private MyJButton btnRmvArt;
    private MyJButton btnLetra;


    /**
     * Construtor da classe Musicasview, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public MusicasView() {

        inicializar(this, "CRUD Música", getPnlTitle(), getPnlBody(), getPnlRodape());
        //REGISTRA OS EVENTOS
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
        btnVoltar.addActionListener(this);
        btnAddArt.addActionListener(this);
        btnRmvArt.addActionListener(this);
        btnLetra.addActionListener(this);

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
        MyJLabel lblTitle = new MyJLabel("Crud de musicas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJButton, e tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com os JButtons instanciados.
     */
    public MyJPanel getPnlBody() {
        if (pnlBody == null) {
            pnlBody = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        btnAdd = new MyJButton("Cadastrar Musica");
        btnRemove = new MyJButton("Remover Musica");
        btnUpdate = new MyJButton("Atualizar Musica");
        btnList = new MyJButton("Listar Musicas");
        btnAddArt = new MyJButton("Adicionar artista na Música");
        btnRmvArt = new MyJButton("Remover artista da Música");
        btnLetra = new MyJButton("Ver letra da Música");

        pnlBody.add(btnAdd);
        pnlBody.add(btnRemove);
        pnlBody.add(btnUpdate);
        pnlBody.add(btnList);
        pnlBody.add(btnLetra);
        pnlBody.add(btnAddArt);
        pnlBody.add(btnRmvArt);

        return pnlBody;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a parte inferior da tela.
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
        captura de eventos da interface EventListener, para detectar cliques nos botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdd) {
            this.dispose();
            new AddMusicaView();
        }

        if (src == btnRemove) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new RemoveMusicaView();
        }

        if (src == btnUpdate) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new UpdateMusicaView();
        }

        if (src == btnList) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new ListarMusicasView();
        }

        if (src == btnAddArt) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new AdicionarArtistasView();
        }

        if (src == btnRmvArt) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new RemoverArtistaView();
        }

        if (src == btnLetra) {
            if (isMusicasEmpty()) {
                openDialog("musica");
                return;
            }
            this.dispose();
            new LetraView();
        }

        if (src == btnVoltar) {
            this.dispose();
            new MainView();
        }
    }
}
