package main.view.ouvintes;

import main.controller.OuvinteController;
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
import static main.controller.PlaylistController.arrayPlaylistsCadastradas;
import static main.controller.PlaylistController.buscarPlaylistPorNome;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

public class AdicionarPlaylistsView extends JFrame implements ActionListener {

    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJComboBox<String> cboxPlaylist;
    private MyJComboBox<Ouvinte> cboxOuvinte;

    private MyJButton btnAdd;
    private MyJButton btnCancelar;

    public AdicionarPlaylistsView() {
        inicializar(this, "CRUD Ouvinte", getPnlTitle(), getPnlForm(), getPnlRodape());
        btnAdd.addActionListener(this);
        btnCancelar.addActionListener(this);
    }
//	---------------------------------------------------------------------------

    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Adicionar Playlist");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

//	---------------------------------------------------------------------------

    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(2, 2));
        }
        MyJLabel lblPlaylist = new MyJLabel("Playlist:");
        MyJLabel lblOuvinte = new MyJLabel("Ouvinte:");

        cboxPlaylist = new MyJComboBox<>(arrayPlaylistsCadastradas());
        cboxOuvinte = new MyJComboBox<>(arrayOuvintesCadastrados());

        pnlForm.add(lblOuvinte);
        pnlForm.add(cboxOuvinte);
        pnlForm.add(lblPlaylist);
        pnlForm.add(cboxPlaylist);

        return pnlForm;
    }

//	---------------------------------------------------------------------------

    public MyJPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        btnAdd = new MyJButton("Adicionar", true);
        btnCancelar = new MyJButton("Cancelar", true);

        pnlRodape.add(btnAdd);
        pnlRodape.add(btnCancelar);

        return pnlRodape;
    }

    //	---------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnAdd) {
            OuvinteController controller = new OuvinteController((Ouvinte) cboxOuvinte.getSelectedItem());
            if (!controller.adicionarPlaylist(
                    buscarPlaylistPorNome((String) cboxPlaylist.getSelectedItem()))) {
                openDialog("playlist_repetida");
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
