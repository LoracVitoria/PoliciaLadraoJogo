package projetoFinal;

public class Fugitivo extends Personagem {

    public Fugitivo(int x, int y,int largura,int altura){
        this.x = x;
        this.y =y;
        this.largura = largura;
        this.altura = altura;
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public Fugitivo(){}

    @Override
    public void andar(char dir) {
        super.andar(dir);
    }
}
