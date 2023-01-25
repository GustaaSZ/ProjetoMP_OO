package main.view.musicas;

import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.MusicaController.*;
import static main.util.Inicializacao.inicializar;

/**
 * Classe view de letra de musica, que se relaciona com a classe de musicaController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 */
public class LetraView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextArea txtLetra;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnVoltar;


    /**
     * Construtor da classe letraView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public LetraView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnVoltar.addActionListener(this);
    }


    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     *
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        MyJLabel lblTitle = new MyJLabel("Letra da Música");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    //	-------------------------------------------------------------

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela, na parte central
     *
     * @return Retorna o JPanel do body com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

        txtLetra = new MyJTextArea();
        txtLetra.setText(musicaPorIndex(0).getLetra());

        JScrollPane scrollPane = new JScrollPane(txtLetra);

        pnlForm.add(cboxMusica, BorderLayout.NORTH);
        pnlForm.add(scrollPane);

        cboxMusica.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtLetra.setText(buscarMusicaPorNome((String) cboxMusica.getSelectedItem())
                        .getLetra());
            }
        });

        return pnlForm;
    }

    //	-------------------------------------------------------------

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     *
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

    //	-------------------------------------------------------------

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
