package main.view.ouvintes;

import main.components.MyJButton;
import main.components.MyJLabel;
import main.components.MyJPanel;
import main.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.cadastrarOuvinte;
import static main.util.Inicializacao.inicializar;
import static main.view.ouvintes.DialogOuvintes.openDialog;


/**
 * Classe view de adicionar ouvintes, que se relaciona com a classe de OuvinteController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see cadastrarOuvinte OuvinteController
 */
public class AddOuvintesView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtMusicaFavorita;

    private MyJButton btnCriar;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe AddOuvintesView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public AddOuvintesView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        // REGISTRA OS EVENTOS
        btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte superior com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Crud de Ouvintes");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJTextField, tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JLabels e JTextFields instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(6, 2));
            // pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(20);

        MyJLabel lblMusicaFavorita = new MyJLabel("Musica Favorita:");
        txtMusicaFavorita = new MyJTextField(20);

        pnlForm.add(lblNome);
        pnlForm.add(txtNome);

        pnlForm.add(lblMusicaFavorita);
        pnlForm.add(txtMusicaFavorita);

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
        btnCriar = new MyJButton("Cadastrar");
        btnCancelar = new MyJButton("Cancelar");

        pnlRodape.add(btnCriar);
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

        if (src == btnCriar) {
            if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
                openDialog("error");
                return;
            }
            if (!cadastrarOuvinte(txtNome.getText(), txtMusicaFavorita.getText())) {
                openDialog("error");
                return;
            }
            cadastrarOuvinte(txtNome.getText(), txtMusicaFavorita.getText());
            this.dispose();
            new OuvintesView();
            openDialog("success");
            // JOptionPane.showMessageDialog(null, "Ouvinte Cadastrado com Sucesso!");
        }

        if (src == btnCancelar) {
            this.dispose();
            new OuvintesView();
        }
    }

//	-----------------------------------------------------------------------------

}

