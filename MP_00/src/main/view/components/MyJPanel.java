package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

    // ---------- Panel para o Header e Footer ----------
    public MyJPanel(FlowLayout flowLayout) {
        super(flowLayout);
        setBackground(AesthethicsView.getCorFundoBtn());
    }

    //---------- Panels para o Body ----------

    public MyJPanel(FlowLayout flowLayout, boolean isForm) {
        super(flowLayout);
        setBackground(isForm ? AesthethicsView.getCorFundo() : AesthethicsView.getCorFundoBtn());
    }
    public MyJPanel(GridLayout gridLayout) {
        super(gridLayout);
        setBackground(AesthethicsView.getCorFundo());
    }

    public MyJPanel(BorderLayout borderLayout) {
        super(borderLayout);
        setBackground(AesthethicsView.getCorFundo());
    }
}
