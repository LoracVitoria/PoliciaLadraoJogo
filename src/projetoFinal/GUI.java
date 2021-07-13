package projetoFinal;

import com.sun.source.tree.ReturnTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    JFrame janela;
    Container container;
    List<JPanel> areas;
    Color corPanel;
    JPanel pessoa;

    // Método Construtor
    public GUI(){
        criaFrame();
        criaContainer();
        criaAreas();
        criaPessoa();
        geraMapa();
        //setUndecorated(true);  // excluir botão de maximizar a tela
        setVisible(true);
    }

    public void criaFrame(){
        janela = new JFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,900);
        janela.setTitle("Fugindo do Banco");
        janela.setResizable(false);
    }

    public void criaContainer(){
        container=getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        setContentPane(container);
    }
    public void criaAreas(){
        areas = new ArrayList<>();

    }

    public void criaPessoa(){
        pessoa = new JPanel();
        pessoa.setBackground(Color.RED);
        pessoa.setBounds(35,630,25,80);
        container.add(pessoa);

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

        for (JPanel panel: areas){
            container.add(panel);
        }
    }
}
