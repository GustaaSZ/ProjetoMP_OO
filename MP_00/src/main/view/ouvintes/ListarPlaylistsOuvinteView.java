package main.view.ouvintes;

import main.model.Playlist;
import main.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.OuvinteController.*;
import static main.util.Inicializacao.inicializar;

/**
 * Classe view de Listar playlists do Ouvinte, que se relaciona com a classe de OuvinteController, 
   em específico com o método de buscarOuvintePorNome
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see OuvinteController
 */
public class ListarPlaylistsOuvinteView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxOuvinte;

    private MyJList<Playlist> lista;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe ListarPlaylistsOuvinteView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public ListarPlaylistsOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA O EVENTO
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
        MyJLabel lblTitle = new MyJLabel("Lista de Playlists do Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel, MyJComboBox e MyJList, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JLabels, JComboBox e JLists instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        DefaultListModel<Playlist> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < ouvintePorIndex(0).getPlaylists().size(); i++) {
            model.add(i, ouvintePorIndex(0).getPlaylists().get(i));
        }

        pnlForm.add(cboxOuvinte, BorderLayout.NORTH);
        pnlForm.add(lista, BorderLayout.CENTER);

        cboxOuvinte.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lista.setListData(
                        arrayPlaylistsPorOuvinte(buscarOuvintePorNome(
                        		(String) cboxOuvinte.getSelectedItem())));
            }
        });
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
            new OuvintesView();
        }
    }

}
