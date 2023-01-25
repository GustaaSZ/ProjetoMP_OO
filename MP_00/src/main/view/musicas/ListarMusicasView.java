package main.view.musicas;

import main.model.Musica;
import main.util.AesthethicsView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJList;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.MusicaController.musicaPorIndex;
import static main.controller.MusicaController.quantidadeMusicasCadastradas;
import static main.util.Inicializacao.inicializar;

/**
 * Classe view de listarMusicasView, que se relaciona com a classe de musicaController.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see MusicaController
 */
public class ListarMusicasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe ListarMusicasView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public ListarMusicasView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());
        //REGISTRA O EVENTO
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
        MyJLabel lblTitle = new MyJLabel("Lista de Musicas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJList, JScrollPane, JViewport e tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }

        DefaultListModel<Musica> model = new DefaultListModel<>();
        MyJList<Musica> lista = new MyJList<>(model);
        for (int i = 0; i < quantidadeMusicasCadastradas(); i++) {
            model.add(i, musicaPorIndex(i));
        }

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JViewport viewport = scroll.getViewport();
        int w = 500;
        int h = viewport.getPreferredSize().height;
        Dimension preferredSize = new Dimension(w, h);
        viewport.setPreferredSize(preferredSize);

        pnlForm.add(scroll);
        pnlForm.setBackground((AesthethicsView.getCorFundo()));

        return pnlForm;
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
     * @param (ActionEvent e) está diretamente ligado com a
        captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnVoltar) {
            this.dispose();
            new MusicasView();
        }
    }

}
