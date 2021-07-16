package projetoFinal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Regra {
    public Regra() {}

    public boolean verificaColisao(List<JPanel> areas, int x, int y, int largura, int altura) {
        for (JPanel area : areas) {
                    // Vertical
            if (((y >= area.getY() && y <= (area.getY() + area.getHeight())) || ((y + altura) >= area.getY()
                    && (y + altura) <= (area.getY() + area.getHeight())))

                    // Horizontal
                    && ((x >= area.getX() && x <= (area.getX() + area.getWidth())) || ((x + largura) >= area.getX()
                    && (x + largura) <= (area.getX() + area.getWidth())))) {

                return true;
            }
        }
        return false;
    }



}
