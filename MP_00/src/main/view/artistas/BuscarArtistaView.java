package main.view.artistas;

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
 * Classe com a view de buscar artistas cadastrados.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @since 2023
 * @version 1.0
 */
public class BuscarArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;


    private MyJButton btnBuscar;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe, chama o método inicializar e adiciona o listener aos JButtons.
     * @see Inicializacao.
     */
    public BuscarArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
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
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela, na parte central
     * @return Retorna o JPanel do body com os JButtons e JLabels instanciados.
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
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
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
     * @param actionEvente e, que está diretamente ligado com a 
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
