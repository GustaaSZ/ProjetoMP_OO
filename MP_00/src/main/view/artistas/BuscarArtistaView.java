package main.view.artistas;

import main.util.Inicializacao;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.objetoEncontrado;
import static main.view.components.Dialog.openDialog;

/**
 * Classe com a view de buscar artistas cadastrados. View que se relaciona com a classe de ArtistaController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see ArtistaController
 */
public class BuscarArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;


    private MyJButton btnBuscar;
    private MyJButton btnCancelar;


    /**
     * Construtor da classe BuscarArtistaView, chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public BuscarArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnBuscar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Buscar Artista");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

     /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e o MyJTextField.
       Tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com o JLabel e o JTexField instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(20);

        pnlForm.add(lblNome);
        pnlForm.add(txtNome);

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton.
       Tem como objetivo editar a parte inferior da tela.
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     * @return
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        btnBuscar = new MyJButton("Buscar");
        btnCancelar = new MyJButton("Voltar");

        pnlRodape.add(btnBuscar, true);
        pnlRodape.add(btnCancelar, true);

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

        if (src == btnBuscar) {
            if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
                openDialog("error");
                return;
            }

            if (objetoEncontrado(buscarArtistaPorNome(txtNome.getText()))) {
                return;
            }
            openDialog("artista_nao_encontrado");
        }

        if (src == btnCancelar) {
            this.dispose();
            new ArtistasView();
        }
    }

}
