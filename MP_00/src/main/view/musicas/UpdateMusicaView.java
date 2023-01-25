package main.view.musicas;

import main.controller.MusicaController;
import main.view.components.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;

import static main.controller.MusicaController.*;
import static main.util.Conversor.dateToString;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view UpdateMusicaView, que se relaciona com a classe de musicaController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see MusicaController
 */
public class UpdateMusicaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtGenero;
    private MyJFormattedTextField txtLancamento;
    private MyJTextArea txtLetra;

    private MyJComboBox<String> cboxMusica;

    private MyJButton btnUpdt;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe UpdateMusicaView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public UpdateMusicaView() {
        inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
        //REGISTRA OS EVENTOS
        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a parte superior da tela.
     *
     * @return Retorna o JPanel da parte inferior com o JLabel instanciado.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Atualizar Música");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel, MyJTextField, MyJComboBox e MyJTextArea, tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com os JLabels, JComboBoxs, JTextFields e JTextArea's instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(5, 5));
        }

        MyJLabel lblMusica = new MyJLabel("Música:");
        cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(20);
        txtNome.setText(musicaPorIndex(0).getNome());

        MyJLabel lblGenero = new MyJLabel("Genero:");
        txtGenero = new MyJTextField(15);
        txtGenero.setText(musicaPorIndex(0).getGenero());

        MyJLabel lblLancamento = new MyJLabel("Lancamento:");
        txtLancamento = new MyJFormattedTextField(setMascara());
        txtLancamento.setText(dateToString(musicaPorIndex(0).getLancamento()));

        MyJLabel lblLetra = new MyJLabel("Letra:");
        txtLetra = new MyJTextArea();
        txtLetra.setLineWrap(true);
        txtLetra.setText(musicaPorIndex(0).getLetra());
        JScrollPane scrollPane = new JScrollPane(txtLetra);

        pnlForm.add(lblMusica);
        pnlForm.add(cboxMusica);
        pnlForm.add(lblNome);
        pnlForm.add(txtNome);
        pnlForm.add(lblGenero);
        pnlForm.add(txtGenero);
        pnlForm.add(lblLancamento);
        pnlForm.add(txtLancamento);
        pnlForm.add(lblLetra);
        pnlForm.add(scrollPane);


        cboxMusica.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                var selected = buscarMusicaPorNome((String) cboxMusica.getSelectedItem());
                txtNome.setText(selected.getNome());
                txtGenero.setText(selected.getGenero());
                txtLancamento.setText(dateToString(selected.getLancamento()));
                txtLetra.setText(selected.getLetra());
                
            }
        });
       
        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a parte inferior da tela.
     *
     * @return Retorna o JPanel da parte inferior com os JButtons instanciados.
     */
    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnUpdt = new MyJButton("Atualizar");
        btnCancelar = new MyJButton("Cancelar");

        pnlRodape.add(btnUpdt);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

    /**
     * Listener para os JButtons
     *
     * @param (ActionEvent e) está diretamente ligado com a
        captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnUpdt) {
            MusicaController controller = new MusicaController(
                    buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
            controller.atualizarMusica(
                    txtNome.getText(),
                    txtGenero.getText(),
                    txtLancamento.getText(),
                    txtLetra.getText());
            this.dispose();
            new MusicasView();
            openDialog("success");
        }

        if (src == btnCancelar) {
            this.dispose();
            new MusicasView();
        }
    }

    private MaskFormatter setMascara() {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return mask;
    }
}
