package main.view.artistas;

// import main.model.Artista;

import main.model.Musica;
import main.util.AesthethicsView;
import main.util.Inicializacao;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.ArtistaController.*;
// import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.util.Inicializacao.inicializar;

/**
 * Classe com a view de listar musicas de algum artista cadastrado.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class ListarMusicasArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxArtista;

    private MyJList<Musica> lista;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe, chama o método inicializar e adiciona o listener ao JButton.
     *
     * @see Inicializacao
     */
    public ListarMusicasArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnVoltar.addActionListener(this);
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Lista de músicas do Artista");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJList, e tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JButtons, JLabels e MyJList instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        MyJLabel lblArtista = new MyJLabel("Artista:");
        pnlForm.add(lblArtista, BorderLayout.NORTH);

        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        DefaultListModel<Musica> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < artistaPorIndex(0).getMusicas().size(); i++) {
            model.add(i, artistaPorIndex(0).getMusicas().get(i));
        }

        // Adicionando a a lista no JScrollPane, (Barra de rolagem)
        JScrollPane scroll = new JScrollPane(lista);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBackground(AesthethicsView.getCorFundo());

        pnlForm.add(cboxArtista, BorderLayout.NORTH);
        pnlForm.add(scroll);

        cboxArtista.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lista.setListData(
                        arrayMusicasDoArtista(buscarArtistaPorNome(
                                (String) cboxArtista.getSelectedItem()))
                );
            }
        });
        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     *
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
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
     *          captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnVoltar) {
            this.dispose();
            new ArtistasView();
        }
    }
}
