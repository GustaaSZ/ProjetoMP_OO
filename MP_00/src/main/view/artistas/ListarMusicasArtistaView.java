package main.view.artistas;

import main.model.Artista;
import main.model.Musica;
import main.util.AesthethicsView;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.ArtistaController.*;
import static main.util.Inicializacao.inicializar;

public class ListarMusicasArtistaView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<Artista> cboxArtista;

    private MyJList<Musica> lista;

    private MyJButton btnVoltar;

    public ListarMusicasArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnVoltar.addActionListener(this);
    }


    //	-------------------------------------------------------------

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Lista de músicas do Artista");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    //	-------------------------------------------------------------

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new BorderLayout());
        }
        MyJLabel lblArtista = new MyJLabel("Artista:");
        pnlForm.add(lblArtista, BorderLayout.NORTH);

        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        DefaultListModel<Musica> model = new DefaultListModel<>();
        lista = new MyJList<>(model);

        for (int i = 0; i < artistaPorIndex(0).getMusicas().size(); i++) {
            model.add(i, artistaPorIndex(0).getMusicas().get(i));
        }

        // Adicionando a a lista no scroll pane, (Barra de rolagem)
        JScrollPane scroll = new JScrollPane(lista);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBackground(AesthethicsView.getCorFundo());

        pnlForm.add(cboxArtista, BorderLayout.NORTH);
        pnlForm.add(scroll);

        cboxArtista.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lista.setListData(
                        arrayMusicasDoArtista((Artista) cboxArtista.getSelectedItem())
                );
            }
        });
        return pnlForm;
    }

    //	-------------------------------------------------------------

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }

        btnVoltar = new MyJButton("Voltar", true);
        pnlRodape.add(btnVoltar);

        return pnlRodape;
    }

    //	-------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnVoltar) {
            this.dispose();
            new ArtistasView();
        }
    }
}
