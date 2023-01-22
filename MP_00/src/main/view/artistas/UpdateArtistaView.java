package main.view.artistas;

import main.controller.ArtistaController;
import main.model.Artista;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class UpdateArtistaView extends JFrame implements ActionListener {


    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;

    private MyJComboBox<Artista> cboxArtista;

    private MyJButton btnUpdt;
    private MyJButton btnCancelar;

    public UpdateArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Crud de Artistas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    //	-------------------------------------------------------------

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(3, 2), true);
        }
        MyJLabel lblArtista = new MyJLabel("Artista:");
        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(20);
        txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());

        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);
        pnlForm.add(lblNome);
        pnlForm.add(txtNome);

        cboxArtista.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtNome.setText(((Artista) cboxArtista.getSelectedItem()).getNome());
            }
        });
        return pnlForm;
    }

    //	-------------------------------------------------------------

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnUpdt = new MyJButton("Atualizar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnUpdt);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

    //	-------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnUpdt) {
            ArtistaController controller = new ArtistaController((Artista) cboxArtista.getSelectedItem());
            controller.editarNome(txtNome.getText().trim());

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
