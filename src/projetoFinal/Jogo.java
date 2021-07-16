package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo extends JFrame implements KeyListener {

    JFrame janela;
    Container container;
    Fugitivo fugitivo;
    Policial policial;
    Mapa mapa;
    Regra regra;
    boolean areas;

    // Método Construtor
    public Jogo(){
        criaFrame();
        criaContainer();
        instanciar();
        insereComponentes();
        addKeyListener(this);
        mostraPersonagem();
        setUndecorated(true);  // excluir botão de maximizar a tela
        setVisible(true);
    }

    public void instanciar() {
        mapa = new Mapa();
        fugitivo = new Fugitivo(35, 630, 25, 80, 3);
        policial = new Policial();
        regra = new Regra();
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

    public void insereComponentes() {
        for (JPanel panel: mapa.getAreas()){
            container.add(panel);
        }
        container.add(fugitivo.panel);
    }

    public void mostraPersonagem(){
        fugitivo.panel.setBackground(Color.RED);
        atualizaFrame();

    }

    public void atualizaFrame() {
        fugitivo.panel.setBounds(fugitivo.x, fugitivo.y, fugitivo.largura, fugitivo.altura);
    }

    // Controle Teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent p) {
        if (p.getKeyCode() == 39) {
            if (!regra.verificaColisao(mapa.getAreas(),
                                            fugitivo.x + fugitivo.passo,
                                            fugitivo.y,
                                            fugitivo.largura,
                                            fugitivo.altura)) {
                fugitivo.andar('d');
            }
        }
        if (p.getKeyCode() == 37) {
            if (!regra.verificaColisao(mapa.getAreas(),
                                            fugitivo.x - fugitivo.passo,
                                            fugitivo.y,
                                            fugitivo.largura,
                                            fugitivo.altura)) {
                fugitivo.andar('e');
            }
        }

        if (p.getKeyCode() == 38) {
            if (!regra.verificaColisao(mapa.getAreas(),
                                            fugitivo.x,
                                            fugitivo.y - fugitivo.passo,
                                            fugitivo.largura,
                                            fugitivo.altura)) {
                fugitivo.andar('c');
            }
        }

        if (p.getKeyCode() == 40) {
            if (!regra.verificaColisao(mapa.getAreas(),
                                            fugitivo.x,
                                            fugitivo.y + fugitivo.passo,
                                            fugitivo.largura,
                                            fugitivo.altura)) {
                fugitivo.andar('b');
            }
        }

        atualizaFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}




