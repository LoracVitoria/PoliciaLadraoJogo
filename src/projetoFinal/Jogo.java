package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo extends JFrame implements KeyListener {

    JFrame janela;
    Container container;
    Container containerFinal;
    Fugitivo fugitivo;
    Mapa mapa;
    Regra regra;
    boolean areas;
    int xInicial = 35;
    int yInicial = 630;

    // Método Construtor
    public Jogo(){
        criaFrame();
        criaContainer();
        instanciar();
        insereComponentes();
        addKeyListener(this);
        mostraPersonagem();
        setVisible(true);
    }

    public void instanciar() {
        mapa = new Mapa();
        fugitivo = new Fugitivo(xInicial, yInicial, 25, 80, 30);
        regra = new Regra();
    }

    public void criaFrame(){
        janela = new JFrame();
        setUndecorated(true);  // excluir botão de maximizar a tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,900);
        janela.setSize(1300, 900);
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

        if(regra.venceJogo(janela.getWidth(),
                            janela.getHeight(),
                            fugitivo.x,
                            fugitivo.y,
                            fugitivo.largura,
                            fugitivo.altura)) {

            Object[] options = {
                    "Jogar Novamente",
                    "Encerrar o Jogo"
            };

            int result = JOptionPane.showOptionDialog(janela,
                                                    "Parabéns, você venceu o jogo!!!\n\nO que deseja fazer agora?",
                                                    "Fim de Jogo",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    options,
                                                    options[0]);

//            int result = JOptionPane.showOptionDialog(janela,
//                    "Poxa vida, não foi dessa vez...\n\nO que deseja fazer agora?",
//                    "Fim de Jogo",
//                    JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.ERROR_MESSAGE,
//                    null,
//                    options,
//                    options[0]);

            if (result == 0) {
                fugitivo.setX(xInicial);
                fugitivo.setY(yInicial);
            } else {
                System.exit(0);
            }

        }
        atualizaFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}




