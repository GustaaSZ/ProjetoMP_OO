package main.view.musicas;

import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.controller.MusicaController.arrayArtistasNaMusica;
import static main.controller.MusicaController.arrayMusicasCadastradas;
import static main.controller.MusicaController.buscarMusicaPorNome;
import static main.controller.MusicaController.musicaPorIndex;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;

import main.controller.MusicaController;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

public class RemoverArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxArtista;
    private MyJComboBox<String> cboxMusica;

    private MyJButton btnRemove;
    private MyJButton btnCancelar;

    public RemoverArtistaView() {
        inicializar(this, "CRUD Música", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnRemove.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Remover Artista de alguma Música");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2));
        }

        MyJLabel lblArtista = new MyJLabel("Artista:");
        MyJLabel lblMusica = new MyJLabel("Música:");

        cboxMusica = new MyJComboBox<>(arrayMusicasCadastradas());
        cboxArtista = new MyJComboBox<>(
                arrayArtistasNaMusica(musicaPorIndex(0)));

        pnlForm.add(lblMusica);
        pnlForm.add(cboxMusica);
        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);

        cboxMusica.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                cboxArtista.removeAllItems();

                var array = arrayArtistasNaMusica(
                        buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));

                for (String artista : array) {
                    cboxArtista.addItem(artista);
                }
            }
        });

        return pnlForm;
    }

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnRemove = new MyJButton("Remover", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnRemove);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnRemove) {
            MusicaController controller = new MusicaController(
                    buscarMusicaPorNome((String) cboxMusica.getSelectedItem()));
            if (!controller.removerArtista(buscarArtistaPorNome((String) cboxArtista.getSelectedItem()))) {
                openDialog("musica_sem_artista");
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
