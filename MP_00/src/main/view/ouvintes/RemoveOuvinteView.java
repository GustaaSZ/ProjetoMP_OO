package main.view.ouvintes;

// import main.model.Ouvinte;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.controller.OuvinteController.removerOuvinteCadastrado;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view de remover Ouvinte, que se relaciona com o método de removerOuvinte da classe OuvinteController
 * 
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see OuvinteController
 */
public class RemoveOuvinteView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxOuvinte;

    private MyJButton btnRemover;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe RemoveOuvinteView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public RemoveOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnRemover.addActionListener(this);
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
        MyJLabel lblTitle = new MyJLabel("Remover Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJComboBox, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com o JLabel e o JComboBox instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(1, 2));
        }
        MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        pnlForm.add(lblOuvinte);
        pnlForm.add(cboxOuvinte);

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton, tem como objetivo editar a tela na parte inferior
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
     * @param (ActionEvent e), está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnRemover) {
            if (!removerOuvinteCadastrado(buscarOuvintePorNome(
            		(String) cboxOuvinte.getSelectedItem()))) {
                openDialog("error");
                return;
            }

            this.dispose();
            new OuvintesView();
            openDialog("success");
        }

        if (src == btnCancelar) {
            this.dispose();
            new OuvintesView();
        }
    }

}
