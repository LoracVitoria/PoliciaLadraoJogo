package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mapa extends JPanel {

    List<JPanel> areas;
    List<JPanel> policiais;
    ImageIcon parede;
    List<JLabel> lparede;
    final int LARGURARUA = 100;

    public Mapa(){
        areas = new ArrayList<>();
        lparede = new ArrayList<>();
        policiais = new ArrayList<>();
        geraMapa();
    }

    public List<JPanel> getAreas() {
        return areas;
    }
    public List<JLabel> getLparede(){
        return lparede;
    }


    public JPanel criaPanel(int x, int y, int largura, int altura) {
        JPanel panel = new JPanel();
        panel.setBounds(x,y,largura,altura);
        return panel;
    }
    public JLabel criaLabel(int x, int y, int largura, int altura){
        parede = new ImageIcon("images/parede4.jpg");
        JLabel lbparede;
        lbparede = new JLabel("",parede, JLabel.CENTER);
        lbparede.setIcon(parede);
        lbparede.setBounds(x,y,largura,altura);
        return lbparede;
    }
    public void geraMapa(){
        int x=0, y=0;
       

        // area esquerda - container
        lparede.add(criaLabel(x, y,950,175));
        areas.add(criaPanel(x, y,950,175));
        y+=175+LARGURARUA;
        lparede.add(criaLabel(x, y,250,350));
        areas.add(criaPanel(x, y,250,350));
        y+=350;
        lparede.add(criaLabel(x, y, 20, 100));
        areas.add(criaPanel(x, y, 20, 100));
        y+=LARGURARUA;
        lparede.add(criaLabel(x, y, 250, 175));
        areas.add(criaPanel(x, y, 250, 175));

        // area central - container
        x =250 + LARGURARUA;
        y=175+LARGURARUA;
        lparede.add(criaLabel(x, y,250,350));
        areas.add(criaPanel(x, y,250,350));
        lparede.add(criaLabel(2*x, y,250,350));
        areas.add(criaPanel(2*x, y,250,350));
        y+=350+LARGURARUA;
        lparede.add(criaLabel(x, y,600,175));
        areas.add(criaPanel(x, y,600,175));

        // area direira - container
        x+=600+LARGURARUA;
        y=0;
        lparede.add(criaLabel(x, y,250,625));
        areas.add(criaPanel(x, y,250,625));
        y+=625+LARGURARUA;
        lparede.add(criaLabel(x, y,250,175));
        areas.add(criaPanel(x, y,250,175));

        //cobrir a parte branca da direita
        x=1300;
        y=0;
        lparede.add(criaLabel(x, y,410,1000));
    }



}
