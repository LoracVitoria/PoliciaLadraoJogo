package projetoFinal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Regra {

    public Regra() {
    }

    private boolean checaColisao(int fugX, int fugY, int fugLargura, int fugAltura,
                                 int objX, int objY, int objLargura, int objAltura) {
        if (((fugY >= objY && fugY <= (objY + objAltura))
                || ((fugY + fugAltura) >= objY
                && (fugY + fugAltura) <= (objY + objAltura)))

                // Horizontal
                && ((fugX >= objX && fugX <= (objX + objLargura))
                || ((fugX + fugLargura) >= objX
                && (fugX + fugLargura) <= (objX + objLargura)))) {

            return true;
        } else {
            return false;
        }
    }

    public boolean verificaColisao(List<JPanel> objeto, int x_fugitivo, int y_fugitivo,
                                   int largura_fugitivo, int altura_fugitivo) {
        for (int i = 0; i < objeto.size(); i++) {
            JPanel area = objeto.get(i);
            // Vertical
//            if (((y_fugitivo >= area.getY() && y_fugitivo <= (area.getY() + area.getHeight()))
//                    || ((y_fugitivo + altura_fugitivo) >= area.getY()
//                    && (y_fugitivo + altura_fugitivo) <= (area.getY() + area.getHeight())))
//
//                    // Horizontal
//                    && ((x_fugitivo >= area.getX() && x_fugitivo <= (area.getX() + area.getWidth()))
//                    || ((x_fugitivo + largura_fugitivo) >= area.getX()
//                    && (x_fugitivo + largura_fugitivo) <= (area.getX() + area.getWidth())))) {
//
//                return true;
//            }
            if (checaColisao(x_fugitivo, y_fugitivo, largura_fugitivo, altura_fugitivo,
                             area.getX(), area.getY(), area.getWidth(), area.getHeight())) {
                return true;
            }
        }
        return false;
    }

    public boolean venceJogo(int larguraJanela, int alturaJanela, int x_fugitivo, int y_fugitivo,
                             int largura_fugitivo, int altura_fugitivo) {

        if (y_fugitivo > alturaJanela || (y_fugitivo + altura_fugitivo) < 0) {
            return true;
        }
        return false;
    }

    public boolean perdeJogo(ArrayList<Policial> policiais, int x_fugitivo, int y_fugitivo,
                             int largura_fugitivo, int altura_fugitivo) {
        for (int i = 0; i < policiais.size(); i++) {
            Policial policial = policiais.get(i);
            if (checaColisao(x_fugitivo, y_fugitivo, largura_fugitivo, altura_fugitivo,
                    policial.x, policial.y, policial.largura, policial.altura)) {
                return true;
            }
        }

        return false;
    }
}
