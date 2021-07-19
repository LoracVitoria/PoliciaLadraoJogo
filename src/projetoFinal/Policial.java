package projetoFinal;

import javax.swing.*;

public class Policial extends Personagem {

    Icon policeImage;
    JLabel lPoliceImage;

    public Policial(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;

        policeImage = new ImageIcon("images/police.gif");
        lPoliceImage = new JLabel("", policeImage, JLabel.CENTER);
        lPoliceImage.setIcon(policeImage);
        lPoliceImage.setBounds(x, y, largura, altura);
    }
    @Override
    public void vigiar(int i) {
        super.vigiar(i);
    }

}
