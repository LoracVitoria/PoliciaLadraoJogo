package projetoFinal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Policial extends Personagem {  // Se relaciona com Personagem =>  Associação por composição (depende de personagem para existir)

    public ArrayList<Integer> LIMITESIni = new ArrayList<>();
    public ArrayList<Integer> LIMITESFin = new ArrayList<>();

    java.util.Timer timer = new Timer();

    public void declararLIMITESIni(){
        LIMITESIni.add(0);
        LIMITESIni.add(285);
        LIMITESIni.add(650); //lembrar que é y
        LIMITESIni.add(285);
        LIMITESIni.add(1000);
    }
    public void declararLIMITESFin(){
        LIMITESFin.add(285);
        LIMITESFin.add(1000);
        LIMITESFin.add(790); //lembrar que é y
        LIMITESFin.add(1000);
        LIMITESFin.add(1250);
    }

    public Icon policeImage;
    public JLabel lPoliceImage;

    public boolean running;


    public Policial(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;

        running = true;

        declararLIMITESIni();
        declararLIMITESFin();
        policeImage = new ImageIcon("images/police.gif");
        lPoliceImage = new JLabel("", policeImage, JLabel.CENTER);
        lPoliceImage.setIcon(policeImage);
        lPoliceImage.setBounds(x, y, largura, altura);
    }
    @Override
    public void andar(int i) {
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    public void run() {
                        //loop infinito
                        while (running) {
                            int passoP = 1;
                            if (i != 2) {
                                if (x <= LIMITESFin.get(i)) {
                                    while (x <= LIMITESFin.get(i)) {

                                        try {
                                            sleep(9);
                                        } catch (Exception erro){}
                                        x += passoP;
                                    }

                                } else {
                                    passoP = -1;
                                    while (x >= LIMITESIni.get(i)){
                                        try {
                                            sleep(9);
                                        } catch (Exception erro){}
                                        x += passoP;
                                    }
                                }
                            } else {
                                if (y <= LIMITESFin.get(i)) {
                                    while (y <= LIMITESFin.get(i)) {
                                        try {
                                            sleep(9);
                                        } catch (Exception erro) {}
                                        y += passoP;
                                    }
                                } else {
                                    passoP = -1;
                                    while (y >= LIMITESIni.get(i)) {
                                        try {
                                            sleep(9);
                                        } catch (Exception erro){}
                                        y += passoP;
                                    }
                                }
                            }
                        }
                    }
                }, 0, 1000);
    }
}
