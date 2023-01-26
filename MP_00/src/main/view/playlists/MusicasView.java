package main.view.playlists;

import static main.controller.PlaylistController.arrayMusicasNaPlaylist;
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.controller.PlaylistController.playlistPorIndex;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJList;
import main.view.components.MyJPanel;

/**
 * Classe de musicas view da playlist, que se relaciona com a classe de PlaylistController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see PlaylistController
 */
public class MusicasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJList<String> lista;

    private MyJComboBox<String> cboxPlaylist;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe MusicasView da playlist, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public MusicasView() {
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
        MyJLabel lblTitle = new MyJLabel("Músicas da Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJComboBox e MyJList, tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JLabeJComboBoxs, os JLists e o Scroll instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());

        DefaultListModel<String> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < playlistPorIndex(0).getMusicas().size(); i++) {
            model.add(i, playlistPorIndex(0).getMusicas().get(i).getNome());
        }

        JScrollPane scroll = new JScrollPane(lista);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        pnlForm.add(cboxPlaylist, BorderLayout.NORTH);
        pnlForm.add(scroll);

        cboxPlaylist.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                var array = arrayMusicasNaPlaylist(buscarPlaylistPorNome(
                        (String) cboxPlaylist.getSelectedItem()));
                if (array.length > 0) {
                    lista.setListData(array);
                } else {
                    lista.setListData(array);
                    openDialog("playlist_vazia");
                }
            }
        });
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
        btnVoltar = new MyJButton("Voltar", true);
        pnlRodape.add(btnVoltar);

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

        if (src == btnVoltar) {
            this.dispose();
            new PlaylistsView();
        }
    }
}
