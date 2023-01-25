package main.view.artistas;

import static main.controller.ArtistaController.arrayArtistasCadastrados;
import static main.controller.ArtistaController.buscarArtistaPorNome;
import static main.controller.ArtistaController.artistaPorIndex;
import static main.util.Inicializacao.inicializar;
import static main.view.components.Dialog.openDialog;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;

import main.controller.ArtistaController;
// import main.model.Artista;
import main.view.components.MyJButton;
import main.view.components.MyJComboBox;
import main.view.components.MyJLabel;
import main.view.components.MyJPanel;
import main.view.components.MyJTextField;

/**
 * Classe com a view de atualizar algum artista cadastrado.
 * @author Arthur Gabriel e Gustavo Abrantes
 * @since 2023
 * @version 1.0
 */
public class UpdateArtistaView extends JFrame implements ActionListener {


    private MyJPanel pnlTitle;
    private MyJPanel pnlForm;
    private MyJPanel pnlRodape;

    private MyJTextField txtNome;
    private MyJTextField txtEstiloMusical;

    private MyJComboBox<String> cboxArtista;

    private MyJButton btnUpdt;
    private MyJButton btnCancelar;

    /**
     * Construtor da classe, chama o método inicializar e adiciona o listener ao JButton.
     * @see Inicializacao.
     */
    public UpdateArtistaView() {
        inicializar(this, "CRUD Artista", getPnlTitle(), getPnlForm(), getPnlRodape());

        btnUpdt.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJLabel, e tem como objetivo editar a tela na parte superior
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlTitle() {
        if (pnlTitle == null) {
            pnlTitle = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        }
        MyJLabel lblTitle = new MyJLabel("Crud de Artistas");
        pnlTitle.add(lblTitle);

        return pnlTitle;
    }

    /**
     * Método que instância objetos das classes MyJPanel, MyJLabel e MyJComboBox, e tem como objetivo editar a tela, na parte central
     * @return Retorna o JPanel do body com os JButtons e JLabels instanciados.
     */
    public MyJPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new MyJPanel(new GridLayout(7, 2));
        }
        MyJLabel lblArtista = new MyJLabel("Artista:");
        cboxArtista = new MyJComboBox<>(arrayArtistasCadastrados());

        MyJLabel lblNome = new MyJLabel("Nome:");
        txtNome = new MyJTextField(15);
        txtNome.setText(artistaPorIndex(0).getNome());

        MyJLabel lblEstiloMusical = new MyJLabel("Estilo Musical:");
        txtEstiloMusical = new MyJTextField(15);
        txtEstiloMusical.setText(artistaPorIndex(0).getEstiloMusical());

        pnlForm.add(lblArtista);
        pnlForm.add(cboxArtista);
        pnlForm.add(lblNome);
        pnlForm.add(txtNome);
        pnlForm.add(lblEstiloMusical);
        pnlForm.add(txtEstiloMusical);

        cboxArtista.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtNome.setText((String) cboxArtista.getSelectedItem());
                txtEstiloMusical.setText((buscarArtistaPorNome((String) cboxArtista.getSelectedItem())).getEstiloMusical());
            }
        });
        return pnlForm;
    }

    /**
     * Método que instância objetos das classes MyJPanel e MyJButton e tem como objetivo editar a tela na parte inferior
     * @return Retorna o JPanel da parte inferior com os JButtons e JLabels instanciados.
     */
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

    /**
     * Listener para os JButtons
     * @param actionEvente e, que está diretamente ligado com a 
       captura de eventos da interface EventListener, para detectar cliques em botões.
     */ 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnUpdt) {
            ArtistaController controller = new ArtistaController(
            		(buscarArtistaPorNome((String) cboxArtista.getSelectedItem())));
            
            controller.editarArtista(txtNome.getText().trim(),
            						 txtEstiloMusical.getText().trim());

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
