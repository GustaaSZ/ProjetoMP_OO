package main.view.ouvintes;

import main.model.Ouvinte;
import main.util.AesthethicsView;
import main.view.components.MyJButton;
import main.view.components.MyJLabel;
import main.view.components.MyJList;
import main.view.components.MyJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.controller.OuvinteController.ouvintePorIndex;
import static main.controller.OuvinteController.quantidadeOuvintesCadastrados;
import static main.util.Inicializacao.inicializar;

public class ListarOuvintesView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJButton btnVoltar;

    public ListarOuvintesView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnVoltar.addActionListener(this);
    }

//	----------------------------------------------------------------------

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Lista de Ouvintes");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

//	----------------------------------------------------------------------

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new FlowLayout(FlowLayout.CENTER), true);
        }
        DefaultListModel<Ouvinte> model = new DefaultListModel<>();
        MyJList<Ouvinte> lista = new MyJList<>(model);

        for (int i = 0; i < quantidadeOuvintesCadastrados(); i++) {
            model.add(i, ouvintePorIndex(i));
        }

        JScrollPane scroll = new JScrollPane(lista);
        pnlForm.add(scroll);
        pnlForm.setBackground(AesthethicsView.getCorFundo());

        return pnlForm;
    }

//	----------------------------------------------------------------------

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnVoltar = new MyJButton("Voltar", true);
        pnlRodape.add(btnVoltar);

        return pnlRodape;
    }

//	----------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnVoltar) {
            this.dispose();
            new OuvintesView();
        }
    }
}

