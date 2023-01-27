package main.view.ouvintes;

import main.model.Ouvinte;
import main.util.AesthethicsView;
import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJList;
import main.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.ouvintePorIndex;
import static main.controller.OuvinteController.quantidadeOuvintesCadastrados;
import static main.util.Inicializacao.inicializar;

/**
 * Classe view de Listar Ouvinte, que se relaciona com a classe de OuvinteController, 
   em específico com o método de buscarOuvintePorNome
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see ouvintePorIndex OuvinteController, quantidadeOuvintesCadastrados OuvinteController
 */
public class ListarOuvintesView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe ListarOuvintesView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public ListarOuvintesView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA  O EVENTO
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
        MyJLabel lblTitle = new MyJLabel("Lista de Ouvintes");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel, MyJScrollPane e JViewport, e tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body, os JLabels, JSscrollPane e Jviewport instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        DefaultListModel<Ouvinte> model = new DefaultListModel<>();
        MyJList<Ouvinte> lista = new MyJList<>(model);

        for (int i = 0; i < quantidadeOuvintesCadastrados(); i++) {
            model.add(i, ouvintePorIndex(i));
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
        pnlForm.setBackground(AesthethicsView.getCorFundo());

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
     * @param e está diretamente ligado com a
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

