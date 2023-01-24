package main.view.ouvintes;

import main.controller.OuvinteController;
import main.model.Ouvinte;
import main.view.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.buscarOuvintePorNome;
import static main.controller.OuvinteController.ouvintePorIndex;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class UpdateOuvinteView extends JFrame implements ActionListener {
    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtMusicaFavorita;

    private MyJComboBox<String> cboxOuvinte;

    private MyJButton btnUpdt;
    private MyJButton btnCancelar;


    public UpdateOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Atualizar Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(7, 2));
        }
        MyJLabel lblNome = new MyJLabel("Nome: ");
        txtNome = new MyJTextField(20);
        txtNome.setText(ouvintePorIndex(0).getNome());

        MyJLabel lblMusicaFavorita = new MyJLabel("Musica Favorita: ");
        txtMusicaFavorita = new MyJTextField(20);
        txtMusicaFavorita.setText(ouvintePorIndex(0).getMusicaFavorita());

        MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        pnlForm.add(lblOuvinte);
        pnlForm.add(cboxOuvinte);
        pnlForm.add(lblNome);
        pnlForm.add(txtNome);

        pnlForm.add(lblMusicaFavorita);
        pnlForm.add(txtMusicaFavorita);

        cboxOuvinte.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtNome.setText((buscarOuvintePorNome(
                		(String) cboxOuvinte.getSelectedItem()).getNome()));
                txtMusicaFavorita.setText((buscarOuvintePorNome(
                		(String) cboxOuvinte.getSelectedItem()).getMusicaFavorita()));
            }
        });
        return pnlForm;
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnUpdt) {
            OuvinteController controller = new OuvinteController(buscarOuvintePorNome(
            		(String) cboxOuvinte.getSelectedItem()));
            
            controller.editarOuvinte(txtNome.getText().trim(), txtMusicaFavorita.getText().trim());
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