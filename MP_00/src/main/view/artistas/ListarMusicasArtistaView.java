package main.view.artistas;

// import main.model.Artista;
import main.model.Musica;
import main.util.AesthethicsView;
import main.util.Inicializacao;
import main.components.*;

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
 * @see ArtistaController
 */
public class ListarMusicasArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxArtista;

    private MyJList<Musica> lista;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe ListarMusicasArtistaView, chama o método inicializar e adiciona o listener ao JButton.
     *
     * @see Inicializacao
     */
    public ListarMusicasArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnVoltar.addActionListener(this);
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel. 
       Tem como objetivo editar a parte superior da tela.
     *
     * @return Retorna o JPanel da parte inferior com o JLabel instanciado.
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
     * Método que instância objetos das classes MyJPanel, MyJComboBox, MyJLabel, MyJList e JScrollPane.
       Tem como objetivo editar a parte central da tela
     *
     * @return Retorna o JPanel do body com os JButtons, JLabels , JList e JComboBox instanciados.
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
     * Método que instância objetos das classes MyJPanel e MyJButton. 
      Tem como objetivo editar a parte inferior da tela.
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
     * @param (ActionEvent e). Está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
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
