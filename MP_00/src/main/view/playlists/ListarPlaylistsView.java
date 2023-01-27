package main.view.playlists;

import main.model.Playlist;
import main.util.AesthethicsView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJList;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.PlaylistController.playlistPorIndex;
import static main.controller.PlaylistController.quantidadePlaylistsCadastradas;
import static main.util.Inicializacao.inicializar;

/**
 * Classe view listar Playlist, que se relaciona com a classe
   de PlaylistController, com os métodos de playlistPorIndex e quantidadePlaylistsCadastradas
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class ListarPlaylistsView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe ListarPlaylistsView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public ListarPlaylistsView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA O EVENTO
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
        MyJLabel lblTitle = new MyJLabel("Lista de playlists");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, JScrollPane e MyJList, tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JLabels, os MyJList e o Scroll instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        DefaultListModel<Playlist> model = new DefaultListModel<>();
        MyJList<Playlist> lista = new MyJList<>(model);

        for (int i = 0; i < quantidadePlaylistsCadastradas(); i++) {
            model.add(i, playlistPorIndex(i));
        }

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBackground(AesthethicsView.getCorFundo());

        pnlForm.add(scroll);

        return pnlForm;
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
        btnVoltar = new MyJButton("Voltar");
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

        if (src == btnVoltar) {
            this.dispose();
            new PlaylistsView();
        }
    }

}
