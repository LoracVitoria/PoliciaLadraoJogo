package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mapa extends JPanel {

    List<JPanel> areas;
    List<JPanel> policiais;
    Color corPanel;

    public Mapa(){
        areas = new ArrayList<>();
        policiais = new ArrayList<>();
        geraMapa();
    }

    public List<JPanel> getAreas() {
        return areas; }

    public List<JPanel> getPoliciais(){
        return policiais;
    }

    public JPanel criaPanel(int x, int y, int largura, int altura) {
        JPanel panel = new JPanel();
        corPanel = Color.DARK_GRAY;
        panel.setBackground(corPanel);
        panel.setBounds(x,y,largura,altura);
        return panel;
    }

    public void geraMapa(){
        int x=0, y=0;
        int larguraRua = 100;

        // area esquerda - container
        areas.add(criaPanel(x, y,950,175));
        y+=175+larguraRua;
        areas.add(criaPanel(x, y,250,350));
        y+=350;
        areas.add(criaPanel(x, y, 20, 100));
        y+=larguraRua;
        areas.add(criaPanel(x, y, 250, 175));

        // area central - container
        x =250 + larguraRua;
        y=175+larguraRua;
        areas.add(criaPanel(x, y,250,350));
        areas.add(criaPanel(2*x, y,250,350));
        y+=350+larguraRua;
        areas.add(criaPanel(x, y,600,175));

        // area direira - container
        x+=600+larguraRua;
        y=0;
        areas.add(criaPanel(x, y,250,625));
        y+=625+larguraRua;
        areas.add(criaPanel(x, y,250,175));

    }



}
