package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Jogo extends JFrame implements KeyListener {

    JFrame janela;
    Container container;

    JLabel lfundo;
    JLabel lfugDir;
    JLabel lfugEsq;

    ImageIcon fundo;
    ImageIcon fugDir;
    ImageIcon image;
    ImageIcon fugEsq;

    Fugitivo fugitivo;
    Mapa mapa;
    Regra regra;
    Timer timer;

    ArrayList<Policial> polices;
    ArrayList<Integer> XINICIAL;
    ArrayList<Integer> YINICIAL;

    final int PASSO = 19;      // 20 ou mais não anda em cima
    final int LARGURA = 60;
    final int ALTURA = 80;
    char direcao;

    // Método Construtor
    public Jogo(){
        declaraPosInicial();
        criaFrame();
        criaContainer();
        instanciar();
        insereComponentes();
        addKeyListener(this);
        vigiar();
        atualizar();
        setVisible(true); //por último
    }

    public void instanciar() {
        mapa = new Mapa();
        regra = new Regra();
        timer = new Timer();
        polices = new ArrayList<>();
        fugitivo = new Fugitivo(XINICIAL.get(0), YINICIAL.get(0), LARGURA, ALTURA, PASSO);

        for(int i =1; i < XINICIAL.size(); i++) { //começa com 1 pois o fugitivo é o zero
            polices.add(new Policial(XINICIAL.get(i), YINICIAL.get(i), LARGURA, ALTURA));
        }
    }

    public void declaraPosInicial(){
        XINICIAL = new ArrayList<>();
        XINICIAL.add(30);// primeiro fugitivo
        XINICIAL.add(10);
        XINICIAL.add(610);
        XINICIAL.add(270);
        XINICIAL.add(610);
        XINICIAL.add(1230);

        YINICIAL = new ArrayList<>();
        YINICIAL.add(635); // primeiro fugitivo
        YINICIAL.add(185);
        YINICIAL.add(185);
        YINICIAL.add(785);
        YINICIAL.add(635);
        YINICIAL.add(635);
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
        fundo = new ImageIcon("images/fundoT.jpg");
        lfundo = new JLabel("",fundo, JLabel.CENTER);
        lfundo.setIcon(fundo);
        lfundo.setBounds(0,0,1300,900);
        setContentPane(container);
    }

    public void insereComponentes() {
        for (JLabel lparede : mapa.getLparede()){
            container.add(lparede); //label das paredes
        }
        for (JPanel panel: mapa.getAreas()){
            container.add(panel);    //paredes
        }
        container.add(fugitivo.lFugitivoImage);

        for (int i = 0; i < polices.size(); i++) {
            container.add(polices.get(i).lPoliceImage);
        }
        container.add(lfundo); // deixar por último
    }

    public void vigiar() {
        for (int i = 0; i < 5; i++) {
            polices.get(i).andar(i);
        }
    }


    public void atualizaFrame() {
        fugitivo.lFugitivoImage.setBounds(fugitivo.x, fugitivo.y, fugitivo.largura, fugitivo.altura);
        for (int i = 0; i < polices.size(); i++) {
            polices.get(i).lPoliceImage.setBounds(polices.get(i).x, polices.get(i).y, polices.get(i).largura, polices.get(i).altura);
        }

        if (regra.perdeJogo(polices, fugitivo.x, fugitivo.y, fugitivo.largura, fugitivo.altura)) {
            for(int i = 0; i < polices.size(); i++) {
                polices.get(i).running = false;
            }

            Object[] options = {
                    "Jogar Novamente",
                    "Encerrar o Jogo"
            };

            int result = JOptionPane.showOptionDialog(janela,
                    "MÃOS AO ALTO! VOCÊ ESTÁ PRESO!! ...\n\nO que deseja fazer agora?",
                    "Fim de Jogo",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (result == 0) {
                fugitivo.setX(XINICIAL.get(0));
                fugitivo.setY(YINICIAL.get(0));
                for(int i = 0; i < polices.size(); i++) {
                    polices.get(i).running = true;
                    polices.get(i).andar(i);
                }
            } else {
                System.exit(0);
            }
        } else
        if (regra.venceJogo(janela.getWidth(),
                janela.getHeight(),
                fugitivo.x,
                fugitivo.y,
                fugitivo.largura,
                fugitivo.altura)) {

            Object[] options = {
                    "Jogar Novamente",
                    "Encerrar o Jogo"
            };

            for(int i = 0; i < polices.size(); i++) {
                polices.get(i).running = false;
            }

            int result = JOptionPane.showOptionDialog(janela,
                    "PARABÉNS, você venceu o jogo!!!\n\nO que deseja fazer agora?",
                    "Fim de Jogo",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (result == 0) {
                fugitivo.setX(XINICIAL.get(0));
                fugitivo.setY(YINICIAL.get(0));
                for(int i = 0; i < polices.size(); i++) {
                    polices.get(i).running = true;
                    polices.get(i).andar(i);
                }
            } else {
                System.exit(0);
            }
        }
    }

    public void atualizar(){
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    public void run() {
                        while(true) { // laço infinito
                            atualizaFrame();
                        }
                    }
                }, 0, 1000);
    }

    // Controle Teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent p) {

        if (p.getKeyCode() == 39) {
            if (!regra.verificaColisao(mapa.getAreas(),
                    fugitivo.x + fugitivo.passoF,
                    fugitivo.y,
                    fugitivo.largura,
                    fugitivo.altura)) {
                fugitivo.andar('d');
                direcao = 'd';
                fugDir = new ImageIcon("images/robberdir.gif");
                lfugDir = new JLabel(fugDir);
                fugitivo.lFugitivoImage.setIcon(fugDir);
            }
        }
        if (p.getKeyCode() == 37) {
            if (!regra.verificaColisao(mapa.getAreas(),
                    fugitivo.x - fugitivo.passoF,
                    fugitivo.y,
                    fugitivo.largura,
                    fugitivo.altura)) {
                fugitivo.andar('e');
                direcao = 'e';
                fugEsq = new ImageIcon("images/robberesq.gif");
                lfugEsq = new JLabel(fugEsq, JLabel.CENTER);
                fugitivo.lFugitivoImage.setIcon(fugEsq);
            }
        }

        if (p.getKeyCode() == 38) {
            if (!regra.verificaColisao(mapa.getAreas(),
                    fugitivo.x,
                    fugitivo.y - fugitivo.passoF,
                    fugitivo.largura,
                    fugitivo.altura)) {
                fugitivo.andar('c');
                direcao = 'c';
                fugDir = new ImageIcon("images/robberdir.gif");
                lfugDir = new JLabel(fugDir);
                fugitivo.lFugitivoImage.setIcon(fugDir);

            }
        }

        if (p.getKeyCode() == 40) {
            if (!regra.verificaColisao(mapa.getAreas(),
                    fugitivo.x,
                    fugitivo.y + fugitivo.passoF,
                    fugitivo.largura,
                    fugitivo.altura)) {
                fugitivo.andar('b');
                direcao = 'b';
                fugDir = new ImageIcon("images/robberdir.gif");
                lfugDir = new JLabel(fugDir);
                fugitivo.lFugitivoImage.setIcon(fugDir);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String fugImage;
            if (direcao == 'e') {
                fugImage = "images/robberstopesq.gif";
            } else {
                fugImage = "images/robberstopdir.gif";
            }
            image = new ImageIcon(fugImage);
            fugitivo.lFugitivoImage.setIcon(image);
            fugitivo.lFugitivoImage.setBounds(fugitivo.x, fugitivo.y, fugitivo.largura, fugitivo.altura);
    }
}




