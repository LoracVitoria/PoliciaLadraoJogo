package projetoFinal;

import javax.swing.*;

public class Banco extends JPanel {
    ImageIcon bancoImage;
    JLabel lbanco;
    JLabel ldindin;
    ImageIcon dindin;
    int x = 900;
    int y = 0;
    int altura = 300;
    int largura = 300;
    //int dinheiro = 1000;


    public Banco(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        //this.dinheiro = dinheiro;

        bancoImage = new ImageIcon("images/bank.png");
        lbanco = new JLabel("", bancoImage, JLabel.CENTER);
        lbanco.setIcon(bancoImage);
        lbanco.setBounds(x, y, largura, altura);
        criaBanco(x,y, largura,altura);
    }

    public JPanel criaBanco(int x, int y, int largura, int altura){
        JPanel panelB = new JPanel();
        panelB.setBounds(x,y,largura,altura);

        dindin = new ImageIcon("images/din.gif");
        ldindin = new JLabel(dindin);
        ldindin.setIcon(dindin);
        ldindin.setBounds(150, 400, 80, 80);

        return panelB;

    }

//    public boolean seguranca(int dinheiro){
//        if (dinheiro!=this.dinheiro){
//            return false;
//        }else{
//            return true;
//        }
//    }

}
