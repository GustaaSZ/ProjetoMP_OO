package main.view.ouvintes;

import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;
import main.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.ouvintes.DialogOuvintes.objetoEncontrado;
import static main.view.ouvintes.DialogOuvintes.openDialog;

/**
 * Classe view de buscar Ouvinte por Nome, que se relaciona com a classe de OuvinteController, 
   em específico com o método de buscarOuvintePorNome
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see buscarOuvintePorNome OuvinteController
 */
public class BuscarOuvinteView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;

    private MyJButton btnBuscar;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe BuscarOuvinteView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public BuscarOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Buscar Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com o JLabel instanciado.
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
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */ 
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnBuscar = new MyJButton("Buscar", true);
        btnCancelar = new MyJButton("Voltar", true);

        pnlRodape.add(btnBuscar);
        pnlRodape.add(btnCancelar);

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

        if (src == btnBuscar) {
            if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
                openDialog("error");
                return;
            }
            if (objetoEncontrado(buscarOuvintePorNome(txtNome.getText()))) {
                return;
            }
            openDialog("ouvinte_nao_encontrado");
        }
        if (src == btnCancelar) {
            this.dispose();
            new OuvintesView();
        }
    }
}
