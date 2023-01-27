package main.util;

import java.awt.*;

public class AesthethicsView {

    // Atributo corFundoBtn e o método Getter.
    private static Color corFundoBtn = new Color(54, 54, 54); // Cinza escuro 

    public static Color getCorFundoBtn() {
        return corFundoBtn;
    }

    // Atributo font Instânciando da classe Font e seu método getter.
    private static Font fonte = new Font("Helvitica", Font.BOLD, 15);

    public static Font getFonte() {
        return fonte;
    }

    // Atributo fonteMenor Instânciando da classe Font e seu método getter.
    private static Font fonteMenor = new Font("Helvitica", Font.BOLD, 13);

    public static Font getFonteMenor() {
        return fonteMenor;
    }

    // Atributo corLetra e o método Getter.
    private static Color corLetra = new Color(50, 205, 50); // Verde 

    public static Color getCorLetra() {
        return corLetra;
    }

    // Atributo corFundo e o método Getter.
    private static Color corFundo = new Color(28, 28, 28); // Preto escuro

    public static Color getCorFundo() {
        return corFundo;
    }

}
