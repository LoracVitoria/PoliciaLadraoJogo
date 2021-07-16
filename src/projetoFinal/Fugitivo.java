package projetoFinal;

import javax.swing.*;

public class Fugitivo extends Personagem {

    JPanel panel;

    public Fugitivo(int x, int y,int largura,int altura, int passo){
        this.x = x;
        this.y =y;
        this.largura = largura;
        this.altura = altura;
        this.passo = passo;
        panel = new JPanel();
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }



    @Override
    public void andar(char dir) {
        super.andar(dir);
    }
}
