package main.view.musicas;

import main.controller.MusicaController;
import main.model.Artista;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AdicionarArtistasView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<Artista> cboxArtista;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnAdd;
    private MyJButton btnCancelar;

    public AdicionarArtistasView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnAdd.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Adicionar Artista");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2), true);
        }
        MyJLabel lblMusica = new MyJLabel("Música:");
        cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());

        MyJLabel lblArtista = new MyJLabel("Artista:");
        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);
        pnlForm.add(lblMusica);
        pnlForm.add(cboxMusica);

        return pnlForm;
    }

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnAdd = new MyJButton("Cadastrar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnAdd);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdd) {
            MusicaController controller = new MusicaController(buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
            if (!controller.adicionarArtista((Artista) cboxArtista.getSelectedItem())) {
                openDialog("artista_repetido");
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

}
