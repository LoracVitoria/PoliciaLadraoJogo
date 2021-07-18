package projetoFinal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Regra {

    public Regra() {}

    public boolean verificaColisao(List<JPanel> areas, int x_fugitivo, int y_fugitivo,
                                   int largura_fugitivo, int altura_fugitivo) {
        for (int i = 0; i < areas.size(); i++) {
            JPanel area = areas.get(i);
                    // Vertical
            if (((y_fugitivo >= area.getY() && y_fugitivo <= (area.getY() + area.getHeight()))
                    || ((y_fugitivo + altura_fugitivo) >= area.getY()
                    && (y_fugitivo + altura_fugitivo) <= (area.getY() + area.getHeight())))

                    // Horizontal
                    && ((x_fugitivo >= area.getX() && x_fugitivo <= (area.getX() + area.getWidth()))
                    || ((x_fugitivo + largura_fugitivo) >= area.getX()
                    && (x_fugitivo + largura_fugitivo) <= (area.getX() + area.getWidth())))) {

                return true;
            }
        }
        return false;
    }

    public boolean venceJogo(int larguraJanela, int alturaJanela, int x_fugitivo, int y_fugitivo,
                             int largura_fugitivo, int altura_fugitivo){

        if (y_fugitivo > alturaJanela || (y_fugitivo + altura_fugitivo) < 0) {
            return true;
        }
        return false;
    }



}
