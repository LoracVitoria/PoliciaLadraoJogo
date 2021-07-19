package projetoFinal;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.*;
import static java.lang.Thread.sleep;

public abstract class Personagem implements Comportamento {

    int x, y, passoF=20;
    int altura=80, largura=50;
    ArrayList<Integer> LIMITESIni = new ArrayList<>();
    ArrayList<Integer> LIMITESFin = new ArrayList<>();

    Timer timer = new Timer();

    public Personagem(){
        declararLIMITESIni();
        declararLIMITESFin();
    }

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


    @Override
    public void andar(char dir) {
        switch (dir){
            case 'd':
                x+=passoF;
                break;

            case 'e':
                x-=passoF;
                break;

            case 'c':
                y-=passoF;
                break;

            case 'b':
                y+=passoF;
                break;

            default:
                break;
        }
    }

    @Override
    public void vigiar(int i) {
        // definir movimento
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    public void run() {
                        //loop infinito
                        while (true) {
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
