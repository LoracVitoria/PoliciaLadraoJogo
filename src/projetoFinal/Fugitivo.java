package projetoFinal;

import javax.swing.*;
//import java.lang.*;
import java.awt.*;

public class Fugitivo extends Personagem {     // Se relaciona com Personagem =>  Associação por composição (depende de personagem para existir)

    JPanel panel;
    JLabel lFugitivoImage;
    ImageIcon fugitivoImage;


    public Fugitivo(int x, int y, int largura, int altura, int passoF) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.passoF = passoF;
        panel = new JPanel();

        fugitivoImage = new ImageIcon("images/robberstopdir.gif");
        lFugitivoImage = new JLabel("", fugitivoImage, JLabel.CENTER);
        lFugitivoImage.setIcon(fugitivoImage);
        lFugitivoImage.setBounds(x, y, largura, altura);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public void andar(char dir) {
        super.andar(dir);

    }
}
//    @Override
//    public void roubar() {
//        super.roubar();
//    }
