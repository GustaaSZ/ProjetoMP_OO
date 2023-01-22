package main.view.ouvintes;

import main.model.Ouvinte;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.arrayOuvintesCadastrados;
import static main.controller.OuvinteController.removerOuvinteCadastrado;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class RemoveOuvinteView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<Ouvinte> cboxOuvinte;

    private MyJButton btnRemover;
    private MyJButton btnCancelar;

    // Construtor
    public RemoveOuvinteView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnRemover.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

//	---------------------------------------------------------------------------

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Remover Ouvinte");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

//	----------------------------------------------------------------------

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(1, 2), true);
        }
        MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        pnlForm.add(lblOuvinte);
        pnlForm.add(cboxOuvinte);

        return pnlForm;
    }

//	----------------------------------------------------------------------

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnRemover = new MyJButton("Remover", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnRemover);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

//	----------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnRemover) {
            if (!removerOuvinteCadastrado((Ouvinte) cboxOuvinte.getSelectedItem())) {
                openDialog("error");
                return;
            }

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
