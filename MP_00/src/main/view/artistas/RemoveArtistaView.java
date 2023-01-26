package main.view.artistas;

import main.util.Inicializacao;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.ArtistaController.removerArtistaCadastrado;
import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe com a view de remover artistas cadastrados.
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see ArtistaController
 */
public class RemoveArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxArtista;

    private MyJButton btnRemover;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe RemoveArtistaView, chama o método inicializar e adiciona o listener ao JButton.
     *
     * @see Inicializacao
     */
    public RemoveArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnRemover.addActionListener(this);
        btnCancelar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Remover Artista");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJComboBox. 
       Tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com os JComboBoxs e JLabels instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }

        MyJLabel lblArtista = new MyJLabel("Artista que deseja remover:");
        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton. 
       Tem como objetivo editar a parte inferior da tela.
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnRemover = new MyJButton("Remover", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnRemover);
        pnlRodape.add(btnCancelar);

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

        if (src == btnRemover) {

            if (!removerArtistaCadastrado(buscarArtistaPorNome((String) cboxArtista.getSelectedItem()))) {
                openDialog("error");
                return;
            }
            this.dispose();
            new ArtistasView();
            openDialog("success");
        }

        if (src == btnCancelar) {
            this.dispose();
            new ArtistasView();
        }
    }

}
