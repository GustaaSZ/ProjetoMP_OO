package main.view.components;

import main.util.AesthethicsView;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

    public MyJPanel(FlowLayout flowLayout) {
        super(flowLayout);
        setBackground(AesthethicsView.getCorFundoBtn());
    }
    public MyJPanel(FlowLayout flowLayout, boolean isForm) {
        super(flowLayout);
        setBackground(isForm ? AesthethicsView.getCorFundo() : AesthethicsView.getCorFundoBtn());
    }
    public MyJPanel(GridLayout gridLayout, boolean isForm) {
        super(gridLayout);
        setBackground(isForm ? AesthethicsView.getCorFundo() : AesthethicsView.getCorFundoBtn());
    }

    public MyJPanel(BorderLayout borderLayout, boolean isForm) {
        super(borderLayout);
        setBackground(isForm ? AesthethicsView.getCorFundo() : AesthethicsView.getCorFundoBtn());
    }
}
