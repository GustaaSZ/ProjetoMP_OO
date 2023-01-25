package main.view.musicas;

// import main.model.Artista;
import main.view.components.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.controller.MusicaController.cadastrarMusica;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

/**
 * Classe view de adicionar musica, que se relaciona com a classe de MusicaController
 *
 * @author Arthur Gabriel e Gustavo Abrantes
 * @version 1.0
 * @since 2023
 * @see cadastrarMusica MusicaController
 */
public class AddMusicaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtGenero;
    private MyJFormattedTextField txtLancamento;
    private MyJTextArea txtLetra;

    private MyJComboBox<String> cboxArtista;

    private MyJButton btnCriar;
    private MyJButton btnCancelar;


    /**
     * Construtor da classe AddMusicaView, que chama o método inicializar e adiciona o listener aos JButtons.
     *
     * @see Inicializacao
     */
    public AddMusicaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnCriar.addActionListener(this);
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

        MyJLabel lblTitle = new MyJLabel("Cadastro de musicas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel, MyJTextField,
       JScrollPane e tem como objetivo editar a parte central da tela.
     *
     * @return Retorna o JPanel do body com os JLabels, scrollPanes e JTextFields instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(5, 2));
        }

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(15);

        MyJLabel lblGenero = new MyJLabel("Genero:");
        txtGenero = new MyJTextField(15);

        MyJLabel lblLancamento = new MyJLabel("Lancamento:");
        txtLancamento = new MyJFormattedTextField(setMascara());

        MyJLabel lblLetra = new MyJLabel("Letra:");
        txtLetra = new MyJTextArea();
        JScrollPane scrollPane = new JScrollPane(txtLetra);

        MyJLabel lblArtista = new MyJLabel("Artista:");
        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        pnlForm.add(lblNome);
        pnlForm.add(txtNome);
        pnlForm.add(lblGenero);
        pnlForm.add(txtGenero);
        pnlForm.add(lblLancamento);
        pnlForm.add(txtLancamento);
        pnlForm.add(lblLetra);
        pnlForm.add(scrollPane);
        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);

        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton
       e tem como objetivo editar a parte inferior da tela.
     *
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
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
     * Listener para os JButtons
     *
     * @param (ActionEvent e), está diretamente ligado com a
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnCriar) {
            if (!cadastrarMusica(
            		(buscarArtistaPorNome((String) cboxArtista.getSelectedItem())),
                    txtNome.getText(),
                    txtLetra.getText(),
                    txtGenero.getText(),
                    txtLancamento.getText())) {
                openDialog("error");
                return;
            }
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
