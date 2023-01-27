package main.view.playlists;

import main.controller.PlaylistController;
import main.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.PlaylistController.*;
import static main.util.Inicializacao.inicializar;
import static main.view.playlists.DialogPlaylists.openDialog;

/**
 * Classe de atualizar uma playlist view, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class UpdatePlaylistView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtDescricao;

    private MyJComboBox<String> cboxPlaylist;

    private MyJButton btnUpdt;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe UpdatePlaylistView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public UpdatePlaylistView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Atualizar Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJComboBox, MyJTextField e o MyJLabel. Tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JLabels, JComboBoxs e os JTextFields instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(7, 2));
        }
        MyJLabel lblPlaylist = new MyJLabel("Playlist:");
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(15);
        txtNome.setText(playlistPorIndex(0).getNome());

        MyJLabel lblDescricao = new MyJLabel("Descrição:");
        txtDescricao = new MyJTextField(15);
        txtDescricao.setText(playlistPorIndex(0).getDescricao());

        pnlForm.add(lblPlaylist);
        pnlForm.add(cboxPlaylist);
        pnlForm.add(lblNome);
        pnlForm.add(txtNome);
        pnlForm.add(lblDescricao);
        pnlForm.add(txtDescricao);

        cboxPlaylist.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                var selected = buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem());
                txtNome.setText(selected.getNome());
                txtDescricao.setText(selected.getDescricao());
            }
        });

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a parte inferior da tela
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnUpdt = new MyJButton("Atualizar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnUpdt);
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

        if (src == btnUpdt) {
            PlaylistController controller = new PlaylistController(
                    buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()));
            controller.atualizarPlaylist(
                    txtNome.getText(),
                    txtDescricao.getText()
            );
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
