package main.view.playlists;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.cadastrarPlaylist;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view de adicionar ouvintes, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class AddPlaylistView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtDescricao;

    private MyJButton btnCriar;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe AddPlaylistView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public AddPlaylistView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte superior com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Cadastro de Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJTextField, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JLabels e os JTextFields instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2));
        }
        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(15);

        MyJLabel lblDescricao = new MyJLabel("Descrição:");
        txtDescricao = new MyJTextField(15);

        pnlForm.add(lblNome);
        pnlForm.add(txtNome);
        pnlForm.add(lblDescricao);
        pnlForm.add(txtDescricao);

        return pnlForm;
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
        btnCriar = new MyJButton("Cadastrar");
        btnCancelar = new MyJButton("Cancelar");

        pnlRodape.add(btnCriar);
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

        if (src == btnCriar) {
            if (!cadastrarPlaylist(
                    txtNome.getText(),
                    txtDescricao.getText())) {
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
