package main.view.artistas;

import main.model.Artista;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJList;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.artistaPorIndex;
import static main.controller.ArtistaController.quantidadeArtistasCadastrados;
import static main.util.Inicializacao.inicializar;

/**
 * Classe com a view de listar artistas cadastrados.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @since 2023
 * @version 1.0
 */
public class ListarArtistasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJButton btnVoltar;

    /**
     * Construtor da classe, chama o método inicializar e adiciona o listener ao JButton.
     * @see Inicializacao.
     */
    public ListarArtistasView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnVoltar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        MyJLabel lblTitle = new MyJLabel("Lista de Artistas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJList, e tem como objetivo editar a tela, na parte central
     * @return Retorna o JPanel do body com os JButtons, JLabels e MyJList instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        DefaultListModel<Artista> model = new DefaultListModel<>();
        MyJList<Artista> lista = new MyJList<>(model);

        for (int i = 0; i < quantidadeArtistasCadastrados(); i++) {
            model.add(i, artistaPorIndex(i));
        }

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnlForm.add(scroll);

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
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
     * @param actionEvente e, que está diretamente ligado com a 
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
