package main.view.artistas;

import main.view.components.MyJButton;
import main.view.components.MyJLabel;
 import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.cadastrarArtista;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view de adicionar artista, que se relaciona com a classe de artistaController
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class AddArtistasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtEstiloMusical;


    private MyJButton btnCriar;
    private MyJButton btnCancelar;


    /**
     * Construtor da classe, que instância alguns elementos
       do método inicializar (para inicialização das telas), da classe instanciacao.
     * @see Inicializacao.
     */
    public AddArtistasView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        //REGISTRA O EVENTO
        btnCriar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     * Retorna o texto definido no lblTitle e adicionado no pnlTitle
     * @return String
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        MyJLabel lblTitle = new MyJLabel("Crud de Artistas");

        pnlTitle.add(lblTitle);

        return pnlTitle;
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela, na parte central
     * @return textos e campos de textos definidos e adicionados ao pnlForm
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(6, 2));
            // pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(20);

        MyJLabel lblEstiloMusical = new MyJLabel("Estilo Musical:");
        txtEstiloMusical = new MyJTextField(20);

        pnlForm.add(lblNome);
        pnlForm.add(txtNome);

        pnlForm.add(lblEstiloMusical);
        pnlForm.add(txtEstiloMusical);

        return pnlForm;
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     * Altera o layout para FlowLayout.CENTER
     * @return botões com seus respectivos textos definidos e adicionados ao pnlRodape
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        btnCriar = new MyJButton("Cadastrar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnCriar);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }


    /**
     * Método para gerenciar eventos
     * @param actionEvente e, que está diretamente ligado com a 
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
            if (!cadastrarArtista(txtNome.getText(), txtEstiloMusical.getText())) {
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
