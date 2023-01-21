package main.util;
import java.awt.*;
// import javax.swing.ImageIcon;
// import javax.swing.*;

public class AesthethicsView {

    // Atributo corFundoBtn e os métodos Getters e Setters
    private static Color corFundoBtn = new Color(54, 54, 54); // Cinza escuro 

    public static Color getCorFundoBtn() {
        return corFundoBtn;
    }
    public void setCorFundoBtn(Color corFundoBtn) {
        AesthethicsView.corFundoBtn = corFundoBtn;
    }

    // Atributo fonte Instânciando da classe Font e seus métodos getters e setters
    private static Font fonte = new Font("Helvitica", Font.BOLD,15);
    
    public static Font getFonte() {
        return fonte;
    }
    public static void setFonte(Font fonte) {
        AesthethicsView.fonte = fonte;
    }

    // Atributo fonte2 Instânciando da classe Font e seus métodos getters e setters
    private static Font fonteMenor = new Font("Helvitica", Font.BOLD,13);
    // Courier New
    public static Font getFonteMenor() {
        return fonteMenor;
    }
    public static void setFonteMenor(Font fonteMenor) {
        AesthethicsView.fonteMenor = fonteMenor;
    }

    // // Atributo fonte Instânciando da classe Font e seus métodos getters e setters
    // private static Font fonte3 = new Font("Helvitica", Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,15);
        
    // public static Font getFonte3() {
    //     return fonte3;
    // }
    // public static void setFonte3(Font fonte3) {
    //     AesthethicsView.fonte3 = fonte3;
    // }

    // Atributo corLetra e os métodos Getters e Setters
    private static Color corLetra = new Color(50, 205, 50); // Verde 
    
    public  static Color getCorLetra() {
        return corLetra;
    }
    public void setCorLetra(Color corLetra) {
        AesthethicsView.corLetra = corLetra;
    }

    // Atributo corFundo e os métodos Getters e Setters
    private static Color corFundo = new Color(28 ,28 ,28); // Preto escuro
    
    public static Color getCorFundo() {
        return corFundo;
    }
    public void setCorFundo(Color corFundo) {
        AesthethicsView.corFundo = corFundo;
    }

    // private ImageIcon image = new ImageIcon(getClass().getResource("imagem.jpg"));

    // public ImageIcon getImage() {
    //     return image;
    // }
    // public void  setImage(ImageIcon image) {
    //     this.image = image;
    // }

    // private static JLabel label = new JLabel(image);

    // public static JLabel getLabel() {
    //     return label;
    // }
    // public void setLabel(JLabel label) {
    //     CoresView.label = label;
    // }



}
